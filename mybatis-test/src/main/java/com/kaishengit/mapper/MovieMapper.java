package com.kaishengit.mapper;

import com.kaishengit.entity.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author jinjianghao
 * @date 2018/7/10
 */
public interface MovieMapper {

    List<Movie> findByKeys(@Param("title") String title);
    List<Movie> findByParam(Map<String, Object> queryMap);
    List<Movie> findByIds(@Param("idList") List<Integer> idList);

}
