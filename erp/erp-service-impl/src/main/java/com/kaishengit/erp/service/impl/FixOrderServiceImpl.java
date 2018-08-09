package com.kaishengit.erp.service.impl;

import com.google.gson.Gson;
import com.kaishengit.erp.dto.OrderInfoDto;
import com.kaishengit.erp.dto.OrderStateDto;
import com.kaishengit.erp.entity.Employee;
import com.kaishengit.erp.entity.FixOrder;
import com.kaishengit.erp.entity.FixOrderParts;
import com.kaishengit.erp.entity.Parts;
import com.kaishengit.erp.exception.ServiceException;
import com.kaishengit.erp.mapper.FixOrderMapper;
import com.kaishengit.erp.mapper.FixOrderPartsMapper;
import com.kaishengit.erp.service.FixOrderService;
import com.kaishengit.erp.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/8/8
 */
@Service
public class FixOrderServiceImpl implements FixOrderService {

    @Autowired
    private FixOrderMapper fixOrderMapper;

    @Autowired
    private FixOrderPartsMapper fixOrderPartsMapper;

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 将队列中的数据解析生成维修订单
     *
     * @param json
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void createFixOrder(String json) {
        OrderInfoDto orderInfoDto = new Gson().fromJson(json, OrderInfoDto.class);

        // 解析orderInfoDto信息并入库
        // 封装维修单
        FixOrder fixOrder = new FixOrder();
        fixOrder.setOrderId(orderInfoDto.getOrder().getId());
        fixOrder.setOrderMoney(orderInfoDto.getOrder().getOrderMoney());
        fixOrder.setOrderTime(orderInfoDto.getOrder().getCreateTime());
        fixOrder.setState(orderInfoDto.getOrder().getState());
        fixOrder.setOrderType(orderInfoDto.getServiceType().getServiceName());
        fixOrder.setOrderServiceHour(orderInfoDto.getServiceType().getServiceHour());
        // 计算工时费
        fixOrder.setOrderServiceHourFee(new BigDecimal(Integer.parseInt(orderInfoDto.getServiceType().getServiceHour()) * Constant.DEFAULT_HOUR_FEE));
        // 计算配件费用
        fixOrder.setOrderPartsFee(fixOrder.getOrderMoney().subtract(fixOrder.getOrderServiceHourFee()));

        // 封装车辆信息
        fixOrder.setCarColor(orderInfoDto.getOrder().getCar().getColor());
        fixOrder.setCarLicence(orderInfoDto.getOrder().getCar().getLicenceNo());
        fixOrder.setCarType(orderInfoDto.getOrder().getCar().getCarType());

        // 封装客户信息
        fixOrder.setCustomerName(orderInfoDto.getOrder().getCustomer().getUserName());
        fixOrder.setCustomerTel(orderInfoDto.getOrder().getCustomer().getTel());

        fixOrderMapper.insert(fixOrder);

        // 配件列表入库
        for(Parts parts : orderInfoDto.getPartsList()) {
            FixOrderParts fixOrderParts = new FixOrderParts();
            fixOrderParts.setOrderId(orderInfoDto.getOrder().getId());
            fixOrderParts.setPartsId(parts.getId());
            fixOrderParts.setPartsName(parts.getPartsName());
            fixOrderParts.setPartsNo(parts.getPartsNo());
            fixOrderParts.setPartsNum(parts.getNum());

            fixOrderPartsMapper.insertSelective(fixOrderParts);
        }
    }

    /**
     * 查询待维修列表
     *
     * @return
     */
    @Override
    public List<FixOrder> findFixOrderListWithParts() {
        return fixOrderMapper.findListWithParts();
    }

    /**
     * 接收任务
     * @param id
     * @param employee
     */
    @Override
    public void taskReceive(Integer id, Employee employee) {

        // TODO 判断当前员工下是否有未完成任务


        FixOrder fixOrder = fixOrderMapper.selectByPrimaryKey(id);
        if(fixOrder == null) {
            throw new ServiceException("参数错误或该订单不存在");
        }

        fixOrder.setState(FixOrder.ORDER_STATE_FIXING);
        fixOrder.setFixEmployeeId(employee.getId());
        fixOrder.setFixEmployeeName(employee.getEmployeeName());
        fixOrderMapper.updateByPrimaryKey(fixOrder);

        OrderStateDto orderStateDto = new OrderStateDto();
        orderStateDto.setOrderId(id);
        orderStateDto.setEmployeeId(employee.getId());
        orderStateDto.setState(FixOrder.ORDER_STATE_FIXING);

        sendStateToMQ(orderStateDto);

        // TODO 减少库存
    }

    @Override
    public FixOrder getFixOrder(Integer id) {
        return fixOrderMapper.findWithPartsById(id);
    }

    /**
     * 发送订单状态到消息队列
     * @param orderStateDto
     */
    private void sendStateToMQ(OrderStateDto orderStateDto) {
        // 将对象转成json数据传输到mq中
        String json = new Gson().toJson(orderStateDto);
        jmsTemplate.send("state-queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(json);
            }
        });
    }
}
