package com.kaishengit.test;

import com.kaishengit.entity.Student;
import com.kaishengit.mapper.StudentMapper;
import com.kaishengit.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jinjianghao
 * @date 2018/7/12
 */
public class CacheTestCase {

    Logger logger = LoggerFactory.getLogger(CacheTestCase.class);

    @Test
    public void testCache() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 动态代理获得StudentMapper接口的实现类对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student = studentMapper.findById(1);

        sqlSession.close();

        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        // 动态代理获得StudentMapper接口的实现类对象
        StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);
        student = studentMapper2.findById(1);
        logger.debug("student:{}" , student);
        sqlSession2.close();

    }


}
