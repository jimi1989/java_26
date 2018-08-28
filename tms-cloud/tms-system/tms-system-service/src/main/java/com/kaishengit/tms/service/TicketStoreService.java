package com.kaishengit.tms.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.StoreAccount;
import com.kaishengit.tms.entity.StoreLoginLog;
import com.kaishengit.tms.entity.TicketStore;

import java.util.List;
import java.util.Map;

/**
 * 年票售票点业务类
 * @author fankay
 */
public interface TicketStoreService {
    /**
     * 创建新的售票点
     * @param ticketStore
     */
    void saveNewTicktStore(TicketStore ticketStore);

    /**
     * 根据当前页面和查询参数查询销售点
     * @param pageNo
     * @param queryParam
     * @return
     */
    PageInfo<TicketStore> findAllTicketStoreByPage(Integer pageNo, Map<String, Object> queryParam);

    /**
     * 根据ID查找对应的售票点
     * @param id
     * @return
     */
    TicketStore findTicketStoreById(Integer id);

    /**
     * 根据主键查找售票点账号对象
     * @param id
     * @return
     */
    StoreAccount findStoreAccountById(Integer id);

    /**
     * 修改售票点对象
     * @param ticketStore
     */
    void updateTicketStore(TicketStore ticketStore);

    /**
     * 查找所有的售票点
     * @return
     */
    List<TicketStore> findAllTicketStore();

    /**
     * 根据账号（手机号码）查找售票点登录账号对象
     * @param name
     * @return
     */
    StoreAccount findStoreAccountByName(String name);

    /**
     * 保存售票点的登录日志
     * @param storeLoginLog
     */
    void saveStoreAccountLoginLog(StoreLoginLog storeLoginLog);
}
