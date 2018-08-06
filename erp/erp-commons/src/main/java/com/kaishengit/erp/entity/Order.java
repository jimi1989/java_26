package com.kaishengit.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class Order implements Serializable {

    /**
     * 订单状态 1：新订单 2：已下发 3：维修中 4：维修完成 5：质检中 6：结算中 7：完成
     */
    public static final String ORDER_STATE_NEW = "1";
    public static final String ORDER_STATE_TRANS = "2";
    public static final String ORDER_STATE_FIXING = "3";
    public static final String ORDER_STATE_FIXED = "4";
    public static final String ORDER_STATE_CHECKING = "5";
    public static final String ORDER_STATE_SETTLEMENT = "6";
    public static final String ORDER_STATE_DONE = "7";

    private Integer id;

    /**
     * 订单总价
     */
    private BigDecimal orderMoney;

    /**
     * 订单状态 
     */
    private String state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 车辆id
     */
    private Integer carId;

    /**
     * 工时费
     */
    private Integer serviceTypeId;

    /**
     * 订单车辆
     */
    private Car car;

    /**
     * 订单客户
     */
    private Customer customer;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStateName() {
        //订单状态 1：新订单 2：已下发 3：维修中 4：维修完成 5：质检中 6：结算中 7：完成
        if(getState().equals(ORDER_STATE_NEW)) {
            return "等待维修";
        } else if(getState().equals(ORDER_STATE_TRANS)) {
            return "维修中";
        } else if(getState().equals(ORDER_STATE_FIXING)) {
            return "维修中";
        } else if(getState().equals(ORDER_STATE_FIXED)) {
            return "维修中";
        } else if(getState().equals(ORDER_STATE_CHECKING)) {
            return "质检中";
        } else if(getState().equals(ORDER_STATE_SETTLEMENT)) {
            return "结算中";
        } else if(getState().equals(ORDER_STATE_DONE)) {
            return "完成";
        }
        return "";
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
        Order other = (Order) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderMoney() == null ? other.getOrderMoney() == null : this.getOrderMoney().equals(other.getOrderMoney()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCarId() == null ? other.getCarId() == null : this.getCarId().equals(other.getCarId()))
            && (this.getServiceTypeId() == null ? other.getServiceTypeId() == null : this.getServiceTypeId().equals(other.getServiceTypeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderMoney() == null) ? 0 : getOrderMoney().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCarId() == null) ? 0 : getCarId().hashCode());
        result = prime * result + ((getServiceTypeId() == null) ? 0 : getServiceTypeId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderMoney=").append(orderMoney);
        sb.append(", state=").append(state);
        sb.append(", createTime=").append(createTime);
        sb.append(", carId=").append(carId);
        sb.append(", serviceTypeId=").append(serviceTypeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}