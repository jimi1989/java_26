package com.kaishengit.tms.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class TicketOutRecord implements Serializable {

    public static final String STATE_NO_PAY = "未支付";
    public static final String STATE_PAY = "已支付";

    private Integer id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 下发人
     */
    private String outAccountName;

    /**
     * 财务收款人
     */
    private String financeAccountName;

    /**
     * 状态 未支付|已支付
     */
    private String state;

    /**
     * 内容
     */
    private String content;

    /**
     * 起始票号
     */
    private String beginTicketNum;

    /**
     * 结束票号
     */
    private String endTicketNum;

    /**
     * 总数量
     */
    private Integer totalNum;

    /**
     * 单张票价
     */
    private BigDecimal price;

    /**
     * 总票价
     */
    private BigDecimal totalPrice;

    /**
     * 下发的售票点名称
     */
    private String storeAccountName;

    /**
     * 下发售票点ID
     */
    private Integer storeAccountId;

    /**
     * 下发人ID
     */
    private Integer outAccountId;

    /**
     * 收款人ID
     */
    private Integer financeAccountId;

    /**
     * 支付方式  现金 | 银行卡
     */
    private String payType;

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

    public String getOutAccountName() {
        return outAccountName;
    }

    public void setOutAccountName(String outAccountName) {
        this.outAccountName = outAccountName;
    }

    public String getFinanceAccountName() {
        return financeAccountName;
    }

    public void setFinanceAccountName(String financeAccountName) {
        this.financeAccountName = financeAccountName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStoreAccountName() {
        return storeAccountName;
    }

    public void setStoreAccountName(String storeAccountName) {
        this.storeAccountName = storeAccountName;
    }

    public Integer getStoreAccountId() {
        return storeAccountId;
    }

    public void setStoreAccountId(Integer storeAccountId) {
        this.storeAccountId = storeAccountId;
    }

    public Integer getOutAccountId() {
        return outAccountId;
    }

    public void setOutAccountId(Integer outAccountId) {
        this.outAccountId = outAccountId;
    }

    public Integer getFinanceAccountId() {
        return financeAccountId;
    }

    public void setFinanceAccountId(Integer financeAccountId) {
        this.financeAccountId = financeAccountId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}