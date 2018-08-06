package com.kaishengit.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.erp.entity.*;
import com.kaishengit.erp.mapper.*;
import com.kaishengit.erp.service.OrderService;
import com.kaishengit.erp.util.Constant;
import com.kaishengit.erp.vo.OrderVo;
import com.kaishengit.erp.vo.PartsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Order findOrderById(Integer id) {
        Order order = orderMapper.findWithCarInfoById(id);
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
    public void editOrder(OrderVo orderVo) {
        // 更新订单
        Order order = orderMapper.selectByPrimaryKey(orderVo.getId());
        if(order != null) {
            order.setOrderMoney(orderVo.getFee());
            order.setCarId(orderVo.getCarId());
            order.setServiceTypeId(orderVo.getServiceTypeId());
        }

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
