package com.kaishengit.tms.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.*;
import com.kaishengit.tms.exception.ServiceException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 年票业务类
 * @author jinjianghao
 */
public interface TicketService {
    /**
     * 保存一个入库记录
     * @param ticketInRecord
     * @throws ServiceException 添加失败，则抛出业务异常
     */
    void saveTicketInRecord(TicketInRecord ticketInRecord, Account currAccount) throws ServiceException;

    /**
     * 根据当前页号查询入库记录列表
     * @param pageNo
     * @return
     */
    PageInfo<TicketInRecord> findTicketRecordByPageNo(Integer pageNo);

    /**
     * 根据ID删除年票入库记录
     * @param id
     * @throws ServiceException 删除失败时抛出业务异常
     */
    void delInRecordById(Integer id) throws ServiceException;

    /**
     * 统计各个状态的年票数量
     * @return
     */
    Map<String,Long> countTicketByState();

    /**
     * 保存新的年票下发记录
     * @param ticketOutRecord 下发记录对象
     * @throws ServiceException 保存失败时抛出的异常
     */
    void saveTicketOutRecord(TicketOutRecord ticketOutRecord, Account currAccount) throws ServiceException;

    /**
     * 根据当前页号查询所有的下发记录
     * @param pageNo
     * @return
     */
    PageInfo<TicketOutRecord> findTicketOutRecordByPageNo(Integer pageNo);

    /**
     * 根据主键删除下发单
     * @param id
     */
    void delOutRecordById(Integer id);

    /**
     * 根据当前页号和查询参数查询下发列表
     * @param pageNo 当前页号
     * @param queryParam 查询参数集合
     * @return
     */
    PageInfo<TicketOutRecord> findTicketOutRecordByPageNoAndQueryParam(Integer pageNo, Map<String, Object> queryParam);

    /**
     * 根据主键查找对应的下发单
     * @param id
     * @return
     */
    TicketOutRecord findTicketOutRecordById(Integer id);

}
