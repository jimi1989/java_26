package com.kaishengit.test;

import com.kaishengit.entity.Movie;
import com.kaishengit.mapper.MovieMapper;
import com.kaishengit.mapper.StudentMapper;
import com.kaishengit.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jinjianghao
 * @date 2018/7/10
 */
public class MovieTestCase {

    Logger logger = LoggerFactory.getLogger(MovieTestCase.class);

    private SqlSession sqlSession;
    private MovieMapper movieMapper;

    @Before
    public void before() {
        sqlSession = MybatisUtils.getSqlSession();
        // 动态代理：sqlSession对象根据接口的class动态创建接口的实现类
        movieMapper = sqlSession.getMapper(MovieMapper.class);// 获得接口的实现类对象
    }

    @After
    public void after() {
        sqlSession.close();
    }

    @Test
    public void testFindByKeys() {
        String title = "%老友记%";
        List<Movie> movieList = movieMapper.findByKeys(title);

        logger.debug("size:{}", movieList.size());

    }

    @Test
    public void testFindByParam() {
        Map<String,Object> maps = new HashMap<>();
        // maps.put("title", "%老友记%");
        maps.put("director", "%Kevin Bright%");
        List<Movie> movieList = movieMapper.findByParam(maps);

        logger.debug("size:{}", movieList.size());

    }

    @Test
    public void testFindByIds() {
        List<Integer> idList = Arrays.asList(101,102,103);
        List<Movie> movieList = movieMapper.findByIds(idList);
        logger.debug("size:{}", movieList.size());

    }

}
