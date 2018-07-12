package com.kaishengit.mapper;

import com.kaishengit.entity.Tag;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/7/12
 */
public interface TagMapper {
    @Select("select * from tag where id in (select tag_id from user_tag where user_id = #{id})")
    List<Tag> findByUserId();
}
