package com.kaishengit.service.impl;

import com.kaishengit.entity.Parts;
import com.kaishengit.mapper.PartsMapper;
import com.kaishengit.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jinjianghao
 * @date 2018/7/23
 */
@Service
public class PartsServiceImpl implements PartsService {

    @Autowired
    private PartsMapper partsMapper;
    /**
     * 根据id查询对应的配件对象
     *
     * @param id
     * @return
     */
    @Override
    public Parts findById(Integer id) {
        return partsMapper.selectByPrimaryKey(id);
    }
}
