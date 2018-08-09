package com.kaishengit.erp.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class FixOrderParts implements Serializable {
    private Integer id;

    private Integer orderId;

    private Integer partsId;

    private String partsNo;

    private String partsName;

    private Integer partsNum;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getPartsId() {
        return partsId;
    }

    public void setPartsId(Integer partsId) {
        this.partsId = partsId;
    }

    public String getPartsNo() {
        return partsNo;
    }

    public void setPartsNo(String partsNo) {
        this.partsNo = partsNo;
    }

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    public Integer getPartsNum() {
        return partsNum;
    }

    public void setPartsNum(Integer partsNum) {
        this.partsNum = partsNum;
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
        FixOrderParts other = (FixOrderParts) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getPartsId() == null ? other.getPartsId() == null : this.getPartsId().equals(other.getPartsId()))
            && (this.getPartsNo() == null ? other.getPartsNo() == null : this.getPartsNo().equals(other.getPartsNo()))
            && (this.getPartsName() == null ? other.getPartsName() == null : this.getPartsName().equals(other.getPartsName()))
            && (this.getPartsNum() == null ? other.getPartsNum() == null : this.getPartsNum().equals(other.getPartsNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getPartsId() == null) ? 0 : getPartsId().hashCode());
        result = prime * result + ((getPartsNo() == null) ? 0 : getPartsNo().hashCode());
        result = prime * result + ((getPartsName() == null) ? 0 : getPartsName().hashCode());
        result = prime * result + ((getPartsNum() == null) ? 0 : getPartsNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", partsId=").append(partsId);
        sb.append(", partsNo=").append(partsNo);
        sb.append(", partsName=").append(partsName);
        sb.append(", partsNum=").append(partsNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}