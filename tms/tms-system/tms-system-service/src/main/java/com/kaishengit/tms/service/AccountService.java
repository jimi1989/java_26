package com.kaishengit.tms.service;

import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.entity.AccountLoginLog;
import com.kaishengit.tms.exception.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * 系统账号的业务类
 * @author jinjianghao
 */
public interface AccountService {

    /**
     * 新增账号
     * @param account 账号对象
     * @param rolesIds 账号拥有的角色ID数字
     */
    void saveAccount(Account account, Integer[] rolesIds);

    /**
     * 查询所有账号并加载对应的角色列表
     * @return
     */
    List<Account> findAllAccountWithRoles();

    /**
     * 根据UI传来的查询参数查询所有账号并加载对应的角色列表
     * @param requestParam
     * @return
     */
    List<Account> findAllAccountWithRolesByQueryParam(Map<String, Object> requestParam);

    /**
     * 根据主键查询Account对象
     * @param id
     * @return
     */
    Account findById(Integer id);

    /**
     * 修改账号
     * @param account 账号对象
     * @param rolesIds 账号拥有的角色ID数组
     */
    void updateAccount(Account account, Integer[] rolesIds);

    /**
     * 根据手机号码查询Account对象
     * @param userMobile
     * @return
     */
    Account findByMobile(String userMobile);

    /**
     * 新增Account的登录日志
     * @param accountLoginLog 登录日志对象
     */
    void saveAccountLoginLog(AccountLoginLog accountLoginLog);
}
