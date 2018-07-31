package com.kaishengit.factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jinjianghao
 * @date 2018/7/31
 */
public class StudentTestCase {

    @Test
    public void testSayHello() {
        /*Student stu = new Student();
        stu.sayHello();*/
//        StudentFactory factory = new StudentFactory();
//        factory.getStudent().sayHello();

    }

    @Test
    public void testSpringFactory () {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Student student = (Student) context.getBean("studentFactory");
        System.out.println(student);
    }


}
