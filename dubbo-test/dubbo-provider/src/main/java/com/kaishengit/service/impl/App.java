package com.kaishengit.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author jinjianghao
 * @date 2018/8/11
 */
public class App {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-dubbo-provider.xml");
        context.start();

        System.out.println("容器启动成功");

        System.in.read();
    }

}
