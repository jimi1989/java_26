package com.kaishengit.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
public class FixOrder implements Serializable {
    
	/**
     * 维修订单状态 3：维修中 4：维修完成 5：质检中 6：质检完成
     */
    public static final String ORDER_STATE_FIXING = "3";
    public static final String ORDER_STATE_FIXED = "4";
    public static final String ORDER_STATE_CHECKING = "5";
    public static final String ORDER_STATE_CHECKED = "6";
	
	/**
     * 订单号
     */
    private Integer orderId;

    /**
     * 订单类型
     */
    private String orderType;

    /**
     * 订单日期
     */
    private Date orderTime;

    /**
     * 订单状态：2：已下发 3：维修中 4：维修完成 5：质检中 6：质检完成
     */
    private String state;

    /**
     * 订单金额
     */
    private BigDecimal orderMoney;

    /**
     * 订单工时
     */
    private String orderServiceHour;

    /**
     * 订单工时费
     */
    private BigDecimal orderServiceHourFee;

    /**
     * 订单配件费用
     */
    private BigDecimal orderPartsFee;

    /**
     * 车类型
     */
    private String carType;

    /**
     * 车颜色
     */
    private String carColor;

    /**
     * 车牌号
     */
    private String carLicence;

    /**
     * 车主名称
     */
    private String customerName;

    /**
     * 车主电话
     */
    private String customerTel;

    /**
     * 维修人员id
     */
    private Integer fixEmployeeId;

	 /**
     * 质检人员id
     */
    private Integer checkEmployeeId;

	 /**
     * 维修人员姓名
     */
    private String fixEmployeeName;

	 /**
     * 质检人员姓名
     */
    private String checkEmployeeName;

    private List<FixOrderParts> partsList;

    public List<FixOrderParts> getPartsList() {
        return partsList;
    }

    public void setPartsList(List<FixOrderParts> partsList) {
        this.partsList = partsList;
    }

    private static final long serialVersionUID = 1L;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getOrderServiceHour() {
        return orderServiceHour;
    }

    public void setOrderServiceHour(String orderServiceHour) {
        this.orderServiceHour = orderServiceHour;
    }

    public BigDecimal getOrderServiceHourFee() {
        return orderServiceHourFee;
    }

    public void setOrderServiceHourFee(BigDecimal orderServiceHourFee) {
        this.orderServiceHourFee = orderServiceHourFee;
    }

    public BigDecimal getOrderPartsFee() {
        return orderPartsFee;
    }

    public void setOrderPartsFee(BigDecimal orderPartsFee) {
        this.orderPartsFee = orderPartsFee;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarLicence() {
        return carLicence;
    }

    public void setCarLicence(String carLicence) {
        this.carLicence = carLicence;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    public Integer getFixEmployeeId() {
        return fixEmployeeId;
    }

    public void setFixEmployeeId(Integer fixEmployeeId) {
        this.fixEmployeeId = fixEmployeeId;
    }

    public Integer getCheckEmployeeId() {
        return checkEmployeeId;
    }

    public void setCheckEmployeeId(Integer checkEmployeeId) {
        this.checkEmployeeId = checkEmployeeId;
    }

    public String getFixEmployeeName() {
        return fixEmployeeName;
    }

    public void setFixEmployeeName(String fixEmployeeName) {
        this.fixEmployeeName = fixEmployeeName;
    }

    public String getCheckEmployeeName() {
        return checkEmployeeName;
    }

    public void setCheckEmployeeName(String checkEmployeeName) {
        this.checkEmployeeName = checkEmployeeName;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FixOrder other = (FixOrder) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
            && (this.getOrderTime() == null ? other.getOrderTime() == null : this.getOrderTime().equals(other.getOrderTime()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getOrderMoney() == null ? other.getOrderMoney() == null : this.getOrderMoney().equals(other.getOrderMoney()))
            && (this.getOrderServiceHour() == null ? other.getOrderServiceHour() == null : this.getOrderServiceHour().equals(other.getOrderServiceHour()))
            && (this.getOrderServiceHourFee() == null ? other.getOrderServiceHourFee() == null : this.getOrderServiceHourFee().equals(other.getOrderServiceHourFee()))
            && (this.getOrderPartsFee() == null ? other.getOrderPartsFee() == null : this.getOrderPartsFee().equals(other.getOrderPartsFee()))
            && (this.getCarType() == null ? other.getCarType() == null : this.getCarType().equals(other.getCarType()))
            && (this.getCarColor() == null ? other.getCarColor() == null : this.getCarColor().equals(other.getCarColor()))
            && (this.getCarLicence() == null ? other.getCarLicence() == null : this.getCarLicence().equals(other.getCarLicence()))
            && (this.getCustomerName() == null ? other.getCustomerName() == null : this.getCustomerName().equals(other.getCustomerName()))
            && (this.getCustomerTel() == null ? other.getCustomerTel() == null : this.getCustomerTel().equals(other.getCustomerTel()))
            && (this.getFixEmployeeId() == null ? other.getFixEmployeeId() == null : this.getFixEmployeeId().equals(other.getFixEmployeeId()))
            && (this.getCheckEmployeeId() == null ? other.getCheckEmployeeId() == null : this.getCheckEmployeeId().equals(other.getCheckEmployeeId()))
            && (this.getFixEmployeeName() == null ? other.getFixEmployeeName() == null : this.getFixEmployeeName().equals(other.getFixEmployeeName()))
            && (this.getCheckEmployeeName() == null ? other.getCheckEmployeeName() == null : this.getCheckEmployeeName().equals(other.getCheckEmployeeName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getOrderMoney() == null) ? 0 : getOrderMoney().hashCode());
        result = prime * result + ((getOrderServiceHour() == null) ? 0 : getOrderServiceHour().hashCode());
        result = prime * result + ((getOrderServiceHourFee() == null) ? 0 : getOrderServiceHourFee().hashCode());
        result = prime * result + ((getOrderPartsFee() == null) ? 0 : getOrderPartsFee().hashCode());
        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());
        result = prime * result + ((getCarColor() == null) ? 0 : getCarColor().hashCode());
        result = prime * result + ((getCarLicence() == null) ? 0 : getCarLicence().hashCode());
        result = prime * result + ((getCustomerName() == null) ? 0 : getCustomerName().hashCode());
        result = prime * result + ((getCustomerTel() == null) ? 0 : getCustomerTel().hashCode());
        result = prime * result + ((getFixEmployeeId() == null) ? 0 : getFixEmployeeId().hashCode());
        result = prime * result + ((getCheckEmployeeId() == null) ? 0 : getCheckEmployeeId().hashCode());
        result = prime * result + ((getFixEmployeeName() == null) ? 0 : getFixEmployeeName().hashCode());
        result = prime * result + ((getCheckEmployeeName() == null) ? 0 : getCheckEmployeeName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", orderType=").append(orderType);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", state=").append(state);
        sb.append(", orderMoney=").append(orderMoney);
        sb.append(", orderServiceHour=").append(orderServiceHour);
        sb.append(", orderServiceHourFee=").append(orderServiceHourFee);
        sb.append(", orderPartsFee=").append(orderPartsFee);
        sb.append(", carType=").append(carType);
        sb.append(", carColor=").append(carColor);
        sb.append(", carLicence=").append(carLicence);
        sb.append(", customerName=").append(customerName);
        sb.append(", customerTel=").append(customerTel);
        sb.append(", fixEmployeeId=").append(fixEmployeeId);
        sb.append(", checkEmployeeId=").append(checkEmployeeId);
        sb.append(", fixEmployeeName=").append(fixEmployeeName);
        sb.append(", checkEmployeeName=").append(checkEmployeeName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}