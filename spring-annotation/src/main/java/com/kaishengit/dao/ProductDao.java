package com.kaishengit.dao;

import com.kaishengit.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author jinjianghao
 * @date 2018/7/17
 */
@Repository
public class ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Product product) {
        String sql = "insert into product (product_name, product_inventory) values (?,?)";
        jdbcTemplate.update(sql, product.getProductName(), product.getProductInventory());
    }

    public Product findById(Integer id) {
        String sql = "select * from product where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class),id);
    }

    public List<Product> findAll() {
        String sql = "select * from product";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public int count() {
        String sql = "select count(*) from product";
        return jdbcTemplate.queryForObject(sql,new SingleColumnRowMapper<Long>()).intValue();
    }

    public List<Map<String,Object>> findMapList() {
        String sql = "select * from product";
        return jdbcTemplate.query(sql, new ColumnMapRowMapper());

    }


   /* public Product findById(Integer id) {
        String sql = "select * from product where id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductInventory(rs.getInt("product_inventory"));
                return product;
            }
        },id);
    }*/

}
