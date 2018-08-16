package com.kaishengit.springTask.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * @author jinjianghao
 * @date 2018/8/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-task-annotation.xml")
public class MyTaskJobTestCase {

    @Test
    public void testRun() throws IOException {
        System.out.println("spring started...");
        System.in.read();
    }

}
