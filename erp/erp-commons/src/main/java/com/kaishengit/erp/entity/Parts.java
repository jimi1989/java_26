package com.kaishengit.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 
 */
public class Parts implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 备件编号
     */
    private String partsNo;

    /**
     * 备件名称
     */
    private String partsName;

    /**
     * 进价
     */
    private BigDecimal inPrice;

    /**
     * 售价
     */
    private BigDecimal salePrice;

    /**
     * 库存
     */
    private Integer inventory;

    /**
     * 类型
     */
    private Integer typeId;

    /**
     * 进货地址
     */
    private String address;

    private Type type;

    /**
     * 订单选择数量
     */
    private Integer num;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public BigDecimal getInPrice() {
        return inPrice;
    }

    public void setInPrice(BigDecimal inPrice) {
        this.inPrice = inPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "id=" + id +
                ", partsNo='" + partsNo + '\'' +
                ", partsName='" + partsName + '\'' +
                ", inPrice=" + inPrice +
                ", salePrice=" + salePrice +
                ", inventory=" + inventory +
                ", typeId=" + typeId +
                ", address='" + address + '\'' +
                ", type=" + type +
                '}';
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}