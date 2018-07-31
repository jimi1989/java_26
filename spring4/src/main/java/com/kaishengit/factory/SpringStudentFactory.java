package com.kaishengit.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author jinjianghao
 * @date 2018/7/31
 */
public class SpringStudentFactory implements FactoryBean<Student> {
    @Override
    public Student getObject() throws Exception {
        return new Student();
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
