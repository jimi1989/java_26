package com.kaishengit.erp.vo;

import com.kaishengit.erp.entity.Order;
import com.kaishengit.erp.entity.Parts;
import com.kaishengit.erp.entity.ServiceType;

import java.util.List;

/**
 * 向前端展示订单数据的VO
 * @author jinjianghao
 * @date 2018/8/6
 */
public class OrderInfoVo {

    private Order order;
    private ServiceType serviceType;
    List<Parts> partsList;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<Parts> getPartsList() {
        return partsList;
    }

    public void setPartsList(List<Parts> partsList) {
        this.partsList = partsList;
    }

    @Override
    public String toString() {
        return "OrderInfoVo{" +
                "order=" + order +
                ", serviceType=" + serviceType +
                ", partsList=" + partsList +
                '}';
    }
}
