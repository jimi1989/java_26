package com.kaishengit.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.kaishengit.erp.dto.OrderInfoDto;
import com.kaishengit.erp.dto.OrderStateDto;
import com.kaishengit.erp.entity.*;
import com.kaishengit.erp.exception.ServiceException;
import com.kaishengit.erp.mapper.*;
import com.kaishengit.erp.service.OrderService;
import com.kaishengit.erp.util.Constant;
import com.kaishengit.erp.vo.OrderVo;
import com.kaishengit.erp.vo.PartsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.List;
import java.util.Map;


/**
 * @author jinjianghao
 * @date 2018/8/2
 */
@Service
public class OrderServiceImpl implements OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private ServiceTypeMapper serviceTypeMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderEmployeeMapper orderEmployeeMapper;

    @Autowired
    private OrderPartsMapper orderPartsMapper;

    @Autowired
    private PartsMapper partsMapper;

    @Autowired
    JmsTemplate jmsTemplate;
    /**
     * 查询所有的类型
     *
     * @return
     */
    @Override
    public List<ServiceType> findAllServiceType() {
        ServiceTypeExample serviceTypeExample = new ServiceTypeExample();
        return serviceTypeMapper.selectByExample(serviceTypeExample);
    }

    /**
     * 获得所有的配件类型
     *
     * @return
     */
    @Override
    public List<Type> findAllPartsType() {
        TypeExample typeExample = new TypeExample();
        return typeMapper.selectByExample(typeExample);
    }

    /**
     * 新增订单
     *
     * @param orderVo 前端订单信息
     * @param employeeId 操作的员工id
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void newOrder(OrderVo orderVo, Integer employeeId) {
        // 新增订单
        Order order = new Order();
        order.setCarId(orderVo.getCarId());
        order.setOrderMoney(orderVo.getFee());
        order.setServiceTypeId(orderVo.getServiceTypeId());
        order.setState(Order.ORDER_STATE_NEW);

        orderMapper.insertSelective(order);

        // 新增订单和员工关联关系表
        OrderEmployee orderEmployee = new OrderEmployee();
        orderEmployee.setOrderId(order.getId());
        orderEmployee.setEmployeeId(employeeId);
        orderEmployeeMapper.insertSelective(orderEmployee);

        // 新增订单和配件关系表
        List<PartsVo> partsVoList = orderVo.getPartsLists();
        addOrderParts(order.getId(), partsVoList);

        logger.info("{}新增订单{}", employeeId, order.getId());
    }

    /**
     * 通过参数查询订单
     * @return
     */
    @Override
    public PageInfo<Order> findPageByParam(Map<String,Object> queryMap) {
        PageHelper.startPage(Integer.parseInt(String.valueOf(queryMap.get("pageNo"))),Constant.DEFAULT_PAGE_SIZE);

        List<Order> orderList = orderMapper.findUndonePageByParam(queryMap);

        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        return pageInfo;
    }

    /**
     * 查看订单详情
     *
     * @param id
     * @return order
     */
    @Override
    public Order findOrderById(Integer id) throws ServiceException{
        Order order = orderMapper.findWithCarInfoById(id);
        if(order == null) {
            throw new ServiceException("参数异常或者订单不存在");
        }
        return order;
    }

    /**
     * 获得服务类型
     *
     * @param serviceTypeId
     * @return
     */
    @Override
    public ServiceType findServiceTypeById(Integer serviceTypeId) {
        return serviceTypeMapper.selectByPrimaryKey(serviceTypeId);
    }

    /**
     * 更新订单
     *
     * @param orderVo
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void editOrder(OrderVo orderVo) throws ServiceException{
        // 更新订单
        Order order = orderMapper.selectByPrimaryKey(orderVo.getId());
        if(order == null) {
            throw new ServiceException("参数异常或者订单不存在");
        }

        // 只有状态为1的订单可以被修改
        if(!order.getState().equals(Order.ORDER_STATE_NEW)) {
            throw new ServiceException("该订单已生成，不能修改");
        }

        order.setOrderMoney(orderVo.getFee());
        order.setCarId(orderVo.getCarId());
        order.setServiceTypeId(orderVo.getServiceTypeId());

        orderMapper.updateByPrimaryKeySelective(order);

        // 删除原有的关联关系
        OrderPartsExample orderPartsExample = new OrderPartsExample();
        orderPartsExample.createCriteria().andOrderIdEqualTo(orderVo.getId());
        orderPartsMapper.deleteByExample(orderPartsExample);

        // 新增订单和配件关系表
        List<PartsVo> partsVoList = orderVo.getPartsLists();
        addOrderParts(order.getId(), partsVoList);

        logger.info("更新订单{}", order.getId());
    }

    /**
     * 订单下发
     *
     * @param id
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void transOrder(Integer id) throws ServiceException{
        Order order = orderMapper.selectByPrimaryKey(id);
        if(order == null) {
            throw new ServiceException("参数异常或订单不存在");
        }

        if(!order.getState().equals(Order.ORDER_STATE_NEW)){
            throw new ServiceException(("该订单已经生成并下发，操作失败"));
        }

        // 设置订单状态为已下发
        order.setState(Order.ORDER_STATE_TRANS);
        orderMapper.updateByPrimaryKeySelective(order);

        // 订单下发后将订单信息发送到消息队列
       sendOrderInfoToMq(id);

    }

    /**
     * 解析json数据改变订单状态
     * @param json
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void editOrderState(String json) {
        OrderStateDto orderStateDto = new Gson().fromJson(json, OrderStateDto.class);
        Order order = orderMapper.selectByPrimaryKey(orderStateDto.getOrderId());

        if(order == null) {
            logger.error("{} 订单不存在", orderStateDto.getOrderId());
        }

        // 更改基础表的订单状态
        order.setState(orderStateDto.getState());
        orderMapper.updateByPrimaryKeySelective(order);

        // 新增订单操作员工
        // 如果员工的employeeId==null 则代表员工订单关联关系不需要新增
        if (orderStateDto.getEmployeeId() != null) {
            OrderEmployee orderEmployee = new OrderEmployee();
            orderEmployee.setEmployeeId(orderStateDto.getEmployeeId());
            orderEmployee.setOrderId(order.getId());

            orderEmployeeMapper.insertSelective(orderEmployee);
        }

    }

    /**
     * 发送订单详情信息到队列中
     * @param id
     */
    private void sendOrderInfoToMq(Integer id) {
        // 获得订单信息
        Order order = orderMapper.findWithCarInfoById(id);
        // 获得订单服务类型信息
        ServiceType serviceType = serviceTypeMapper.selectByPrimaryKey(order.getServiceTypeId());
        // 获得订单配件列表
        List<Parts> partsList = partsMapper.findByOrderId(id);

        OrderInfoDto orderInfoDto = new OrderInfoDto();
        orderInfoDto.setOrder(order);
        orderInfoDto.setServiceType(serviceType);
        orderInfoDto.setPartsList(partsList);

        // 转成json发送到mq队列
        String json = new Gson().toJson(orderInfoDto);

        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(json);
            }
        });
    }


    /**
     *    新增配件订单关联关系
      */
    private void addOrderParts(Integer orderId, List<PartsVo> partsVoList) {
        for(PartsVo partsVo : partsVoList) {
            OrderParts orderParts = new OrderParts();
            orderParts.setOrderId(orderId);
            orderParts.setPartsId(partsVo.getId());
            orderParts.setNum(partsVo.getNum());

            orderPartsMapper.insertSelective(orderParts);
        }
    }


}
