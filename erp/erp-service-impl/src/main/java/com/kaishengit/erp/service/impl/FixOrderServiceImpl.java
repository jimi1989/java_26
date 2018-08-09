package com.kaishengit.erp.service.impl;

import com.google.gson.Gson;
import com.kaishengit.erp.dto.OrderInfoDto;
import com.kaishengit.erp.entity.FixOrder;
import com.kaishengit.erp.entity.FixOrderParts;
import com.kaishengit.erp.entity.Parts;
import com.kaishengit.erp.mapper.FixOrderMapper;
import com.kaishengit.erp.mapper.FixOrderPartsMapper;
import com.kaishengit.erp.service.FixOrderService;
import com.kaishengit.erp.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
