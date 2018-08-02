package com.kaishengit.erp.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class Car implements Serializable {
    /**
     * 车辆ID
     */
    private Integer id;

    /**
     * 车辆型号
     */
    private String carType;

    /**
     * 车牌号
     */
    private String licenceNo;

    /**
     * 车辆识别码
     */
    private String carNo;


    /**
     * 车辆颜色
     */
    private String color;

    /**
     * 客户ID
     */
    private Integer customerId;

    /**
     * 客户信息
     */
    private Customer customer;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        Car other = (Car) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCarType() == null ? other.getCarType() == null : this.getCarType().equals(other.getCarType()))
            && (this.getLicenceNo() == null ? other.getLicenceNo() == null : this.getLicenceNo().equals(other.getLicenceNo()))
            && (this.getCarNo() == null ? other.getCarNo() == null : this.getCarNo().equals(other.getCarNo()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getColor() == null ? other.getColor() == null : this.getColor().equals(other.getColor()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());
        result = prime * result + ((getLicenceNo() == null) ? 0 : getLicenceNo().hashCode());
        result = prime * result + ((getCarNo() == null) ? 0 : getCarNo().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getColor() == null) ? 0 : getColor().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", carType=").append(carType);
        sb.append(", licenceNo=").append(licenceNo);
        sb.append(", carNo=").append(carNo);
        sb.append(", customerId=").append(customerId);
        sb.append(", color=").append(color);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}