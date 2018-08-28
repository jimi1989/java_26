package com.kaishengit.tms.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class AccountRolesKey implements Serializable {
    private Integer rolesId;

    private Integer accountId;

    private static final long serialVersionUID = 1L;

    public Integer getRolesId() {
        return rolesId;
    }

    public void setRolesId(Integer rolesId) {
        this.rolesId = rolesId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}