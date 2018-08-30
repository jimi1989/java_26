package com.kaishengit.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TicketInRecord implements Serializable {
    private Integer id;

    /**
     * 创建时间
     */
    private Date createTime;

    private Date updateTime;

    /**
     * 创建人姓名
     */
    private String accountName;

    /**
     * 下发内容
     */
    private String content;

    private Integer accountId;

    /**
     * 起始票号
     */
    private String beginTicketNum;

    /**
     * 结束票号
     */
    private String endTicketNum;

    /**
     * 本次入库数量
     */
    private Integer totalNum;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getBeginTicketNum() {
        return beginTicketNum;
    }

    public void setBeginTicketNum(String beginTicketNum) {
        this.beginTicketNum = beginTicketNum;
    }

    public String getEndTicketNum() {
        return endTicketNum;
    }

    public void setEndTicketNum(String endTicketNum) {
        this.endTicketNum = endTicketNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    @Override
    public String toString() {
        return "TicketInRecord{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", accountName='" + accountName + '\'' +
                ", content='" + content + '\'' +
                ", accountId=" + accountId +
                ", beginTicketNum='" + beginTicketNum + '\'' +
                ", endTicketNum='" + endTicketNum + '\'' +
                ", totalNum=" + totalNum +
                '}';
    }
}