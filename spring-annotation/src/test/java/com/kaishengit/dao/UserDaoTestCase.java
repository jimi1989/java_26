package com.kaishengit.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author jinjianghao
 * @date 2018/7/16
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserDaoTestCase {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSave() {

        // ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        // UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.save();
    }



}
