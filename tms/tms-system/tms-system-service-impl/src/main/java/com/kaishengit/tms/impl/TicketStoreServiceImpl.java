package com.kaishengit.tms.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.*;
import com.kaishengit.tms.mapper.StoreAccountMapper;
import com.kaishengit.tms.mapper.StoreLoginLogMapper;
import com.kaishengit.tms.mapper.TicketStoreMapper;
import com.kaishengit.tms.service.TicketStoreService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 年票售票点业务层
 * @author jinjianghao
 */
@Service(version = "1.0",timeout = 5000)
public class TicketStoreServiceImpl implements TicketStoreService {


    @Autowired
    private TicketStoreMapper ticketStoreMapper;
    @Autowired
    private StoreAccountMapper storeAccountMapper;
    @Autowired
    private StoreLoginLogMapper storeLoginLogMapper;

    /**
     * 创建新的售票点
     * @param ticketStore
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveNewTicktStore(TicketStore ticketStore) {
        ticketStore.setCreateTime(new Date());
        ticketStoreMapper.insertSelective(ticketStore);

        //创建售票点账号
        StoreAccount storeAccount = new StoreAccount();
        storeAccount.setId(ticketStore.getId());
        storeAccount.setStoreAccount(ticketStore.getStoreTel());
        //默认密码为123123
        storeAccount.setStorePassword(DigestUtils.md5Hex(StoreAccount.ACCOUNT_INIT_PASSWORD));
        storeAccount.setCreateTime(new Date());
        storeAccount.setStoreState(StoreAccount.ACCOUNT_STATE_NORMAL);

        storeAccountMapper.insertSelective(storeAccount);
    }

    /**
     * 根据当前页面和查询参数查询销售点
     *
     * @param pageNo
     * @param queryParam
     * @return
     */
    @Override
    public PageInfo<TicketStore> findAllTicketStoreByPage(Integer pageNo, Map<String, Object> queryParam) {
        PageHelper.startPage(pageNo,15);

        String storeName = (String)queryParam.get("storeName");
        String storeManager = (String) queryParam.get("storeManager");
        String storeTel = (String) queryParam.get("storeTel");

        TicketStoreExample ticketStoreExample = new TicketStoreExample();
        TicketStoreExample.Criteria criteria = ticketStoreExample.createCriteria();
        if(StringUtils.isNotEmpty(storeName)) {
            criteria.andStoreNameLike("%"+storeName+"%");
        }
        if(StringUtils.isNotEmpty(storeManager)) {
            criteria.andStoreManagerLike("%"+storeManager+"%");
        }
        if(StringUtils.isNotEmpty(storeTel)) {
            criteria.andStoreTelEqualTo(storeTel);
        }
        ticketStoreExample.setOrderByClause("id desc");

        List<TicketStore> ticketStoreList = ticketStoreMapper.selectByExample(ticketStoreExample);
        return new PageInfo<>(ticketStoreList);
    }

    /**
     * 根据ID查找对应的售票点
     *
     * @param id
     * @return
     */
    @Override
    public TicketStore findTicketStoreById(Integer id) {
        return ticketStoreMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据主键查找售票点账号对象
     *
     * @param id
     * @return
     */
    @Override
    public StoreAccount findStoreAccountById(Integer id) {
        return storeAccountMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改售票点对象
     *
     * @param ticketStore
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateTicketStore(TicketStore ticketStore) {
        ticketStore.setUpdateTime(new Date());

        //判断是否修改了联系电话
        StoreAccount storeAccount = storeAccountMapper.selectByPrimaryKey(ticketStore.getId());
        if(!ticketStore.getStoreTel().equals(storeAccount.getStoreAccount())) {
            //如果修改的电话，则需要同步修改账号
            storeAccount.setStoreAccount(ticketStore.getStoreTel());
            //重新设置密码
            storeAccount.setStorePassword(DigestUtils.md5Hex(ticketStore.getStoreTel().substring(5)));
            storeAccount.setUpdateTime(new Date());

            storeAccountMapper.updateByPrimaryKeySelective(storeAccount);
        }

        ticketStoreMapper.updateByPrimaryKeySelective(ticketStore);
    }

    /**
     * 查找所有的售票点
     *
     * @return
     */
    @Override
    public List<TicketStore> findAllTicketStore() {
        TicketStoreExample ticketStoreExample = new TicketStoreExample();
        ticketStoreExample.setOrderByClause("id desc");
        return ticketStoreMapper.selectByExample(ticketStoreExample);
    }

    /**
     * 根据账号（手机号码）查找售票点登录账号对象
     *
     * @param name
     * @return
     */
    @Override
    public StoreAccount findStoreAccountByName(String name) {
        StoreAccountExample example = new StoreAccountExample();
        example.createCriteria().andStoreAccountEqualTo(name);

        List<StoreAccount> storeAccountList = storeAccountMapper.selectByExample(example);
        if(storeAccountList != null && !storeAccountList.isEmpty()) {
            return storeAccountList.get(0);
        }
        return null;
    }

    /**
     * 保存售票点的登录日志
     *
     * @param storeLoginLog
     */
    @Override
    public void saveStoreAccountLoginLog(StoreLoginLog storeLoginLog) {
        storeLoginLogMapper.insertSelective(storeLoginLog);
    }
}
