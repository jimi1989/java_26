package com.kaishengit.test;

import com.kaishengit.entity.School;
import com.kaishengit.entity.Student;
import com.kaishengit.entity.Tag;
import com.kaishengit.mapper.SchoolMapper;
import com.kaishengit.mapper.StudentMapper;
import com.kaishengit.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/7/10
 */
public class StudentMapperTestCase {
    Logger logger = LoggerFactory.getLogger(StudentMapperTestCase.class);

    private SqlSession sqlSession;
    private StudentMapper studentMapper;

    @Before
    public void before() {
        sqlSession = MybatisUtils.getSqlSession();
        // 动态代理：sqlSession对象根据接口的class动态创建接口的实现类
        studentMapper = sqlSession.getMapper(StudentMapper.class);// 获得接口的实现类对象
    }

    @After
    public void after() {
        sqlSession.close();
    }

    @Test
    public void testFindBySchoolId() {
        SchoolMapper schoolMapper = sqlSession.getMapper(SchoolMapper.class);
        School school = schoolMapper.findById(1);
        System.out.println(school);
    }

    @Test
    public void testFindWithSchoolById() {
        Student student = studentMapper.findWithSchoolById(2);
        logger.debug("student: {}", student);
    }

    @Test
    public void testFindWithTagById() {
        Student student = studentMapper.findWithTagById(2);
        logger.debug("student: {}", student);
    }

    @Test
    public void testAddBatch() {
        Tag tag = new Tag();
        tag.setTagName("直男");

        Tag tag1 = new Tag();
        tag1.setTagName("好人");

        List<Tag> tagList = Arrays.asList(tag, tag1);
        int count = studentMapper.addBatch(tagList);
        sqlSession.commit();
        logger.debug("size:{}" , count);
    }

}
