package com.kaishengit.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * @author jinjianghao
 * @date 2018/7/14
 */
public class BaseServiceTestCase {

    @Test
    public void show() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BaseService baseService = (BaseService) context.getBean("baseService");

        System.out.println(baseService.getId());
        System.out.println(baseService.getName());
        System.out.println(baseService.getScore());

        List<String> nameList = baseService.getStrList();
        for(String name : nameList) {
            System.out.println(name);
        }

        Set<Integer> numSets = baseService.getNumSets();
        for(Integer num : numSets) {
            System.out.println(num);
        }

        Map<String,String> maps = baseService.getMaps();
        for(Map.Entry<String,String> entry: maps.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        Properties props = baseService.getProperties();
        Enumeration<Object> keys = props.keys();

        while(keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = props.get(key);
            System.out.println(key);
            System.out.println(value);
        }



    }

}
