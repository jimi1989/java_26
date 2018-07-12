package com.kaishengit.mapper;

import com.kaishengit.entity.Product;
import org.apache.ibatis.annotations.*;

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
    @Insert(value = "insert into product (product_name, product_inventory) values (#{productName},#{productInventory})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Product product);
    @Select("")
    List<Product> findAll();
    @Select("")
    List<Product> findPage(@Param("start") Integer start, @Param("pageSize")Integer pageSize);
    @Select("")
    List<Product> findPageByMap(Map<String, Integer> map);
    @Select("select id, product_name, product_inventory from product where id = #{id}")
    Product findById(Integer id);
    @Update("update product set product_name = #{productName},  product_inventory = #{productInventory} where id = #{id}")
    void update(Product product);
    @Delete(" delete from product where id = #{id}")
    void deleteById(Integer id);

}
