package com.kaishengit.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jinjianghao
 * @date 2018/7/16
 */
public class UserDaoTestCase {

    @Test
    public void testSave() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.save();
    }



}
