package com.kaishengit.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统账号登录日志实体类
 * @author fankay
 */
public class AccountLoginLog implements Serializable {
    private Long id;

    /**
     * 登录的IP地址
     */
    private String loginIp;

    private Date loginTime;

    private Integer accountId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "AccountLoginLog{" +
                "id=" + id +
                ", loginIp='" + loginIp + '\'' +
                ", loginTime=" + loginTime +
                ", accountId=" + accountId +
                '}';
    }
}