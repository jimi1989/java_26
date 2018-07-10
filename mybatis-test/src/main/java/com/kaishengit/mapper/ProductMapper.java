package com.kaishengit.mapper;

import com.kaishengit.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author jinjianghao
 * @date 2018/7/10
 */
public interface ProductMapper {

    /**
     * 新增产品
     * @param product 产品
     */
    int save(Product product);
    List<Product> findAll();
    List<Product> findPage(@Param("start") Integer start, @Param("pageSize")Integer pageSize);
    List<Product> findPageByMap(Map<String, Integer> map);
    Product findById(Integer id);
    void update(Product product);
    void deleteById(Integer id);

}
