package com.kaishengit.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Ticket implements Serializable {

    public static final String TICKET_STATE_IN_STORE = "已入库";
    public static final String TICKET_STATE_OUT_STORE = "已下发";
    public static final String TICKET_STATE_SALE = "已销售";
    public static final String TICKET_STATE_LOST = "已挂失";
    public static final String TICKET_STATE_OUT_DATE = "已过期";


    private Long id;

    /**
     * 年票号码
     */
    private String ticketNum;

    /**
     * 入库时间
     */
    private Date ticketInTime;

    /**
     * 年票状态
     */
    private String ticketState;

    private Date createTime;

    private Date updateTime;

    /**
     * 年票出库(下发)时间
     */
    private String ticketOutTime;

    /**
     * 售票点ID
     */
    private Integer storeAccountId;

    /**
     * 有效期起始时间
     */
    private Date ticketValidityStart;

    /**
     * 有效期截至时间
     */
    private Date ticketValidityEnd;

    /**
     * 顾客ID
     */
    private Long customerId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }

    public Date getTicketInTime() {
        return ticketInTime;
    }

    public void setTicketInTime(Date ticketInTime) {
        this.ticketInTime = ticketInTime;
    }

    public String getTicketState() {
        return ticketState;
    }

    public void setTicketState(String ticketState) {
        this.ticketState = ticketState;
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

    public String getTicketOutTime() {
        return ticketOutTime;
    }

    public void setTicketOutTime(String ticketOutTime) {
        this.ticketOutTime = ticketOutTime;
    }

    public Integer getStoreAccountId() {
        return storeAccountId;
    }

    public void setStoreAccountId(Integer storeAccountId) {
        this.storeAccountId = storeAccountId;
    }

    public Date getTicketValidityStart() {
        return ticketValidityStart;
    }

    public void setTicketValidityStart(Date ticketValidityStart) {
        this.ticketValidityStart = ticketValidityStart;
    }

    public Date getTicketValidityEnd() {
        return ticketValidityEnd;
    }

    public void setTicketValidityEnd(Date ticketValidityEnd) {
        this.ticketValidityEnd = ticketValidityEnd;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketNum='" + ticketNum + '\'' +
                ", ticketInTime=" + ticketInTime +
                ", ticketState='" + ticketState + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", ticketOutTime='" + ticketOutTime + '\'' +
                ", storeAccountId=" + storeAccountId +
                ", ticketValidityStart=" + ticketValidityStart +
                ", ticketValidityEnd=" + ticketValidityEnd +
                ", customerId=" + customerId +
                '}';
    }
}