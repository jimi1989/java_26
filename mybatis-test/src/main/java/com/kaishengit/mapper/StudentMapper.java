package com.kaishengit.mapper;

import com.kaishengit.entity.Student;
import com.kaishengit.entity.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/7/10
 */
public interface StudentMapper {

    Student findById(Integer id);

    @Select("SELECT" +
            "        student.id," +
            "        user_name," +
            "        address," +
            "        school_id " +
            "    FROM" +
            "    student" +
            "    WHERE" +
            "         student.id = #{id}")
    @Results(
            value = {
                    @Result(column = "id", property = "id"),
                    @Result(column = "user_name",property = "userName"),
                    @Result(column = "address",property = "address"),
                    @Result(column = "school_id",property = "schoolId"),
                    @Result(column = "school_id", property = "school", one = @One(
                            select = "com.kaishengit.mapper.SchoolMapper.findById"
                            )
                    )
            }
    )
    Student findWithSchoolById(Integer id);


    @Select("select * from student where id = #{id}")
    @Results(
            value = {
                    @Result(column = "id", property = "id"),
                    @Result(column = "user_name",property = "userName"),
                    @Result(column = "address",property = "address"),
                    @Result(column = "school_id",property = "schoolId"),
                    @Result(column = "id", property = "tagList", many = @Many(
                            select = "com.kaishengit.mapper.TagMapper.findByUserId"
                    )
                    )
            }
    )
    Student findWithTagById(Integer id);

    int addBatch(@Param("tagList") List<Tag> tagList);

}
