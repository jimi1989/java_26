package com.kaishengit.erp.service;

import com.kaishengit.erp.entity.Employee;
import com.kaishengit.erp.entity.FixOrder;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/8/8
 */
public interface FixOrderService {

    /**
     * 将队列中的数据解析生成维修订单
     * @param json
     */
    void createFixOrder(String json);

    /**
     * 查询待维修列表
     * @return
     */
    List<FixOrder> findFixOrderListWithParts();

    /**
     * 任务领取
     * @param id
     * @param Employee
     */
    void taskReceive(Integer id, Employee Employee);

    /**
     * 任务详情服务页面
     * @param id
     */
    FixOrder getFixOrder(Integer id);
}
