package com.kaishengit.erp.dto;

import com.kaishengit.erp.entity.Order;
import com.kaishengit.erp.entity.Parts;
import com.kaishengit.erp.entity.ServiceType;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/8/8
 */
public class OrderInfoDto {

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
}
