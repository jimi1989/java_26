package com.kaishengit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author jinjianghao
 * @date 2018/8/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class JdbcTest {

    @Autowired
    private Jdbc jdbc;

    @Test
    public void testJdbc() {
        System.out.println(jdbc.getUserName());
    }
}
