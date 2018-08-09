package com.kaishengit.entity;

import com.google.gson.Gson;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author jinjianghao
 * @date 2018/8/9
 */
public class TimeTestCase {


    @Test
    public void testTime() {
        Student student = new Student();

        student.setId(1001);
        student.setName("jack");
        student.setCreateTime(new Timestamp(System.currentTimeMillis()));

        String json = new Gson().toJson(student);
        System.out.println(json);

        Student stu = new Gson().fromJson(json, Student.class);

        System.out.println(stu);


    }


}
