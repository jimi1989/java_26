package com.kaishengit.erp.dto;

/**
 * @author jinjianghao
 * @date 2018/8/9
 */
public class OrderStateDto {

    private Integer orderId;
    private String state;
    private Integer employeeId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
