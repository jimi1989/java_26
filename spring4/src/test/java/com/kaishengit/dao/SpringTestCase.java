package com.kaishengit.dao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jinjianghao
 * @date 2018/7/13
 */
public class SpringTestCase {

    @Test
    public void testSave() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
      /*  UserDao userDao2 = (UserDao) context.getBean("userDao");
        System.out.println(userDao == userDao2);*/
        // userDao.save();

        context.close();
    }

}
