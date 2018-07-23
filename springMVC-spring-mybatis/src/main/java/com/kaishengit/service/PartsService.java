package com.kaishengit.service;

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
}
