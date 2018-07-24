package com.kaishengit.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Parts;

/**
 * @author jinjianghao
 * @date 2018/7/23
 */
public interface PartsService {
    /**
     * 根据id查询对应的配件对象
     * @param id
     * @return
     */
    Parts findById(Integer id);

    /**
     * 根据页码获得对应的数据集合
     * @param pageNo 页码 1，2，3
     * @return pageInfo对象
     */
    PageInfo<Parts> findPage(Integer pageNo);
}
