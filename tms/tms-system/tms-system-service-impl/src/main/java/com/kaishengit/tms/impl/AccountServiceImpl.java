package com.kaishengit.tms.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kaishengit.tms.entity.*;
import com.kaishengit.tms.mapper.AccountLoginLogMapper;
import com.kaishengit.tms.mapper.AccountMapper;
import com.kaishengit.tms.mapper.AccountRolesMapper;
import com.kaishengit.tms.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 系统账号的业务类
 * @author jinjianghao
 */
@Service(version = "1.0",timeout = 5000)
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountLoginLogMapper accountLoginLogMapper;

    @Autowired
    private AccountRolesMapper accountRolesMapper;

    /**
     * 新增账号
     *
     * @param account  账号对象
     * @param rolesIds 账号拥有的角色ID数字
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveAccount(Account account, Integer[] rolesIds) {
        account.setCreateTime(new Date());
        //账号默认密码为手机号码的后6位
        String password;
        if(account.getAccountMobile().length() <= 6) {
            password = account.getAccountMobile();
        } else {
            password = account.getAccountMobile().substring(6);
        }
        //对密码进行MD5加密
        password = DigestUtils.md5Hex(password);

        account.setAccountPassword(password);

        //账号默认状态
        account.setAccountState(Account.STATE_NORMAL);
        accountMapper.insertSelective(account);

        //添加账号和角色的对应关系表
        for(Integer roleId : rolesIds) {
            AccountRolesKey accountRolesKey = new AccountRolesKey();
            accountRolesKey.setAccountId(account.getId());
            accountRolesKey.setRolesId(roleId);

            accountRolesMapper.insert(accountRolesKey);
        }
    }

    /**
     * 查询所有账号并加载对应的角色列表
     *
     * @return
     */
    @Override
    public List<Account> findAllAccountWithRoles() {
        return accountMapper.findAllWithRoles();
    }

    /**
     * 根据UI传来的查询参数查询所有账号并加载对应的角色列表
     *
     * @param requestParam
     * @return
     */
    @Override
    public List<Account> findAllAccountWithRolesByQueryParam(Map<String, Object> requestParam) {
        return accountMapper.findAllWithRolesByQueryParam(requestParam);
    }

    /**
     * 根据主键查询Account对象
     *
     * @param id
     * @return
     */
    @Override
    public Account findById(Integer id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改账号
     *
     * @param account  账号对象
     * @param rolesIds 账号拥有的角色ID数组
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateAccount(Account account, Integer[] rolesIds) {
        //添加账号的修改时间
        account.setUpdateTime(new Date());
        accountMapper.updateByPrimaryKeySelective(account);

        //删除原有的账号-角色关系
        AccountRolesExample accountRolesExample = new AccountRolesExample();
        accountRolesExample.createCriteria().andAccountIdEqualTo(account.getId());
        accountRolesMapper.deleteByExample(accountRolesExample);

        //新增账号-角色关系
        if(rolesIds != null) {
            for (Integer rolesId : rolesIds) {
                AccountRolesKey accountRolesKey = new AccountRolesKey();
                accountRolesKey.setRolesId(rolesId);
                accountRolesKey.setAccountId(account.getId());
                accountRolesMapper.insertSelective(accountRolesKey);
            }
        }

        logger.info("修改账号 {}",account);
    }

    /**
     * 根据手机号码查询Account对象
     *
     * @param userMobile
     * @return
     */
    @Override
    public Account findByMobile(String userMobile) {
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andAccountMobileEqualTo(userMobile);

        List<Account> accountList = accountMapper.selectByExample(accountExample);
        if(accountList != null && !accountList.isEmpty()) {
            return accountList.get(0);
        }
        return null;
    }

    /**
     * 新增Account的登录日志
     *
     * @param accountLoginLog 登录日志对象
     */
    @Override
    public void saveAccountLoginLog(AccountLoginLog accountLoginLog) {
        accountLoginLogMapper.insertSelective(accountLoginLog);
    }
}
