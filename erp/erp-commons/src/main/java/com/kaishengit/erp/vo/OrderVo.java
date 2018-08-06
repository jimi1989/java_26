package com.kaishengit.erp.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 接受前端数据
 * @author jinjianghao
 * @date 2018/8/3
 */
public class OrderVo {

    private Integer id;
    private Integer carId;
    private Integer serviceTypeId;
    private BigDecimal fee;
    private List<PartsVo> partsLists;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public List<PartsVo> getPartsLists() {
        return partsLists;
    }

    public void setPartsLists(List<PartsVo> partsLists) {
        this.partsLists = partsLists;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                "carId=" + carId +
                ", serviceTypeId=" + serviceTypeId +
                ", fee=" + fee +
                ", partsLists=" + partsLists +
                '}';
    }
}
