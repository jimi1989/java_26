package com.kaishengit.mapper;

import com.kaishengit.entity.School;
import org.apache.ibatis.annotations.Select;

/**
 * @author jinjianghao
 * @date 2018/7/12
 */
public interface SchoolMapper {

    @Select("select * from school where id = #{id}")
    School findById(Integer id);

}
