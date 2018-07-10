package com.kaishengit.mapper;

import com.kaishengit.entity.Student;
import com.kaishengit.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/7/10
 */
public interface StudentMapper {

    Student findWithSchoolById(Integer id);

    Student findWithTagById(Integer id);

    int addBatch(@Param("tagList") List<Tag> tagList);

}
