package com.kaishengit.erp.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.erp.entity.*;
import com.kaishengit.erp.vo.OrderVo;

import java.util.List;
import java.util.Map;

/**
 * @author jinjianghao
 * @date 2018/8/2
 */
public interface OrderService {
    /**
     * 查询所有的服务类型
     * @return
     */
    List<ServiceType> findAllServiceType();

    /**
     * 获得所有的配件类型
     * @return
     */
    List<Type> findAllPartsType();

    /**
     * 新增订单
     * @param orderVo
     * @param employeeId 操作的员工id
     */
    void newOrder(OrderVo orderVo, Integer employeeId);

    /**
     * 通过状态查询订单列表
     * @return
     */
    PageInfo<Order> findPageByParam(Map<String,Object> queryMap);


}
