package com.kaishengit.erp.service;

import com.kaishengit.erp.entity.*;

import java.util.List;

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

}
