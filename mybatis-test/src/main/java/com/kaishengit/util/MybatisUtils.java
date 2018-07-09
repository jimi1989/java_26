package com.kaishengit.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author jinjianghao
 * @date 2018/7/9
 */
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        // 1.读取mybatis主配置文件
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 2.创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession(boolean aotuCommit) {
        return getSqlSessionFactory().openSession(aotuCommit);
    }

    public static SqlSession getSqlSession() {
        return getSqlSessionFactory().openSession();
    }
}
