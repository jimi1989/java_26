package com.kaishengit.tms.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kaishengit.tms.entity.*;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.mapper.*;
import com.kaishengit.tms.service.TicketService;
import com.kaishengit.tms.util.SnowFlake;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 年票业务类
 * @author jinjianghao
 */
@Service(version = "1.0", timeout = 5000)
public class TicketServiceImpl implements TicketService {

    private static final Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

    @Value("${snowFlake.dataCenterId}")
    private Integer snowFlakeDataCenter;

    @Value("${snowFlake.machineId}")
    private Integer snowFlakeMachineId;

    @Autowired
    private TicketInRecordMapper ticketInRecordMapper;

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private TicketOutRecordMapper ticketOutRecordMapper;

    @Autowired
    private TicketStoreMapper ticketStoreMapper;

    /**
     * 保存一个入库记录
     *
     * @param ticketInRecord
     * @param currAccount 当前登录对象
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveTicketInRecord(TicketInRecord ticketInRecord, Account currAccount) throws ServiceException {
        BigInteger start = new BigInteger(ticketInRecord.getBeginTicketNum());
        BigInteger end = new BigInteger(ticketInRecord.getEndTicketNum());
        if(start.compareTo(end) >= 0) {
            throw new ServiceException("起始票号必须小于截至票号");
        }

        //判断当前的入库票号的范围是否和之前入库的范围重合，如果重回则不能添加
        List<TicketInRecord> ticketInRecordList = ticketInRecordMapper.selectByExample(new TicketInRecordExample());
        for(TicketInRecord record : ticketInRecordList) {
            BigInteger recordStart = new BigInteger(record.getBeginTicketNum());
            BigInteger recordEnd = new BigInteger(record.getEndTicketNum());
            boolean flag = (recordStart.compareTo(start) <= 0 && recordEnd.compareTo(start) >= 0) || (recordStart.compareTo(end) <= 0 && recordEnd.compareTo(end) >= 0);
            if(flag) {
                throw new ServiceException("票号区间重复，添加失败");
            }
        }

        //设置入库时间
        ticketInRecord.setCreateTime(new Date());
        //获取总数量=截至票号-起始票号+1
        BigInteger totalNUm = end.subtract(start).add(new BigInteger(String.valueOf(1)));
        ticketInRecord.setTotalNum(totalNUm.intValue());

        ticketInRecord.setAccountId(currAccount.getId());
        ticketInRecord.setAccountName(currAccount.getAccountName());

        //设置入库的内容
        ticketInRecord.setContent(ticketInRecord.getBeginTicketNum()+"-"+ticketInRecord.getEndTicketNum());
        ticketInRecordMapper.insertSelective(ticketInRecord);

        logger.info("新增年票入库： {} 入库人：{}",ticketInRecord, currAccount);

        //添加totalNum条年票记录
        List<Ticket> ticketList = new ArrayList<>();
        for(int i = 0;i < totalNUm.intValue();i++) {
            Ticket ticket = new Ticket();
            ticket.setCreateTime(new Date());
            ticket.setTicketInTime(new Date());
            ticket.setTicketNum(start.add(new BigInteger(String.valueOf(i))).toString());
            ticket.setTicketState(Ticket.TICKET_STATE_IN_STORE);
            ticketList.add(ticket);
        }

        //批量保存年票记录
        ticketMapper.batchInsert(ticketList);
    }

    /**
     * 根据当前页号查询入库记录列表
     *
     * @param pageNo
     * @return
     */
    @Override
    public PageInfo<TicketInRecord> findTicketRecordByPageNo(Integer pageNo) {
        PageHelper.startPage(pageNo,15);

        TicketInRecordExample inRecordExample = new TicketInRecordExample();
        inRecordExample.setOrderByClause("id desc");

        List<TicketInRecord> ticketInRecordList = ticketInRecordMapper.selectByExample(inRecordExample);
        return new PageInfo<>(ticketInRecordList);
    }

    /**
     * 根据ID删除年票入库记录
     * @param id
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delInRecordById(Integer id) {
        //查找对应的年票记录
        TicketInRecord inRecord = ticketInRecordMapper.selectByPrimaryKey(id);
        if(inRecord != null) {
            //查找该记录对应的年票
            List<Ticket> ticketList = ticketMapper.findByBeginNumAndEndNumAndState(inRecord.getBeginTicketNum(),inRecord.getEndTicketNum(),Ticket.TICKET_STATE_IN_STORE);

            //判断年票数量和入库记录总数量是否相同，如果不同，则表示有的年票状态已经发生修改，不能删除
            if(!inRecord.getTotalNum().equals(ticketList.size())) {
                throw new ServiceException("该批次年票状态已经发生改变，不能删除");
            }
            //删除年票
            List<Long> idList = Lists.newArrayList(Collections2.transform(ticketList, new Function<Ticket, Long>() {
                @Override
                public Long apply(Ticket f) {
                    return f.getId();
                }
            }));
            ticketMapper.batchDeleteById(idList);
            //删除年票入库记录
            ticketInRecordMapper.deleteByPrimaryKey(id);
        }
    }

    /**
     * 统计各个状态的年票数量
     *
     * @return
     */
    @Override
    public Map<String, Long> countTicketByState() {
        return ticketMapper.countByState();
    }

    /**
     * 保存新的年票下发记录
     *
     * @param ticketOutRecord 下发记录对象
     * @throws ServiceException 保存失败时抛出的异常
     */
    @Override
    public void saveTicketOutRecord(TicketOutRecord ticketOutRecord, Account currAccount) throws ServiceException {
        //判断当前票段内是否有非[已入库]状态的票，如果有则不能下发
        List<Ticket> ticketList = ticketMapper.findByBeginNumAndEndNum(ticketOutRecord.getBeginTicketNum(),ticketOutRecord.getEndTicketNum());

        for(Ticket ticket : ticketList) {
            if(!Ticket.TICKET_STATE_IN_STORE.equals(ticket.getTicketState())) {
                throw new ServiceException("该票段内有已经下发的票，请重新选择");
            }
        }

        //获取当前下发的售票点对象，并赋值售票点名称
        TicketStore ticketStore = ticketStoreMapper.selectByPrimaryKey(ticketOutRecord.getStoreAccountId());
        ticketOutRecord.setStoreAccountName(ticketStore.getStoreName());
        //选择的总数量
        int totalSize = ticketList.size();
        //总价格
        BigDecimal totalPrice = ticketOutRecord.getPrice().multiply(new BigDecimal(totalSize));
        //当前登录的对象


        ticketOutRecord.setCreateTime(new Date());
        ticketOutRecord.setContent(ticketOutRecord.getBeginTicketNum() + " - " + ticketOutRecord.getEndTicketNum());
        ticketOutRecord.setOutAccountId(currAccount.getId());
        ticketOutRecord.setOutAccountName(currAccount.getAccountName());
        ticketOutRecord.setTotalNum(totalSize);
        ticketOutRecord.setState(TicketOutRecord.STATE_NO_PAY);
        ticketOutRecord.setTotalPrice(totalPrice);

        ticketOutRecordMapper.insertSelective(ticketOutRecord);

        logger.info("新增年票下发记录：{}",ticketOutRecord);
    }

    /**
     * 根据当前页号查询所有的下发记录
     *
     * @param pageNo
     * @return
     */
    @Override
    public PageInfo<TicketOutRecord> findTicketOutRecordByPageNo(Integer pageNo) {
        return findTicketOutRecordByPageNoAndQueryParam(pageNo,Maps.newHashMap());
    }

    /**
     * 根据主键删除下发单
     *
     * @param id
     */
    @Override
    public void delOutRecordById(Integer id) {
        TicketOutRecord record = ticketOutRecordMapper.selectByPrimaryKey(id);
        if(record != null) {
            //只有未支付的才可以删除
            if(TicketOutRecord.STATE_NO_PAY.equals(record.getState())) {
                ticketOutRecordMapper.deleteByPrimaryKey(id);
            }
        }
    }

    /**
     * 根据当前页号和查询参数查询下发列表
     *
     * @param pageNo     当前页号
     * @param queryParam 查询参数集合
     * @return
     */
    @Override
    public PageInfo<TicketOutRecord> findTicketOutRecordByPageNoAndQueryParam(Integer pageNo, Map<String, Object> queryParam) {
        PageHelper.startPage(pageNo,15);

        TicketOutRecordExample ticketOutRecordExample = new TicketOutRecordExample();
        TicketOutRecordExample.Criteria criteria = ticketOutRecordExample.createCriteria();

        String state = (String) queryParam.get("state");
        if(StringUtils.isNotEmpty(state)) {
            criteria.andStateEqualTo(state);
        }
        ticketOutRecordExample.setOrderByClause("id desc");

        List<TicketOutRecord> ticketOutRecordList = ticketOutRecordMapper.selectByExample(ticketOutRecordExample);
        return new PageInfo<>(ticketOutRecordList);
    }

    /**
     * 根据主键查找对应的下发单
     *
     * @param id
     * @return
     */
    @Override
    public TicketOutRecord findTicketOutRecordById(Integer id) {
        return ticketOutRecordMapper.selectByPrimaryKey(id);
    }
}
