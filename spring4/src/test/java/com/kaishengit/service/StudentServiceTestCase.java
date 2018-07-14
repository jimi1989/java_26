package com.kaishengit.service;

import com.kaishengit.dao.StudentDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jinjianghao
 * @date 2018/7/14
 */
public class StudentServiceTestCase {

    @Test
    public void testSave() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) context.getBean("studentService");
        studentService.save();

    }



}
