package com.kaishengit.tms.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class TicketOrder implements Serializable {

    public static final String ORDER_TYPE_NEW = "新办订单";
    public static final String ORDER_TYPE_RENEW = "续费订单";
    public static final String ORDER_TYPE_REPLACE = "补办订单";

    private Long id;

    /**
     * 流水号
     */
    private String ticketOrderNum;

    /**
     * 价格
     */
    private BigDecimal ticketOrderPrice;

    private Date createTime;

    private Date updateTime;

    private Long ticketId;

    private Long customerId;

    private Integer storeAccountId;

    /**
     * 类型 新办|续费|补卡
     */
    private String ticketOrderType;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketOrderNum() {
        return ticketOrderNum;
    }

    public void setTicketOrderNum(String ticketOrderNum) {
        this.ticketOrderNum = ticketOrderNum;
    }

    public BigDecimal getTicketOrderPrice() {
        return ticketOrderPrice;
    }

    public void setTicketOrderPrice(BigDecimal ticketOrderPrice) {
        this.ticketOrderPrice = ticketOrderPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getStoreAccountId() {
        return storeAccountId;
    }

    public void setStoreAccountId(Integer storeAccountId) {
        this.storeAccountId = storeAccountId;
    }

    public String getTicketOrderType() {
        return ticketOrderType;
    }

    public void setTicketOrderType(String ticketOrderType) {
        this.ticketOrderType = ticketOrderType;
    }
}