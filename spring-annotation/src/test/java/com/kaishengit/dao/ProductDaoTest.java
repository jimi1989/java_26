package com.kaishengit.dao;

import com.kaishengit.BaseTestCase;
import com.kaishengit.entity.Product;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author jinjianghao
 * @date 2018/7/17
 */
public class ProductDaoTest extends BaseTestCase {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testSave() {

        Product product = new Product();
        product.setProductName("三星 s8x");
        product.setProductInventory(180);

        productDao.save(product);

    }


    @Test
    public void findById() {
        Product product = productDao.findById(17);
        System.out.println(product);
        Assert.assertNotNull(product);
    }

    @Test
    public void save() {
    }

    @Test
    public void findAll() {
        List<Product> productList = productDao.findAll();
        for(Product product : productList) {
            System.out.println(product);
        }

    }

    @Test
    public void count() {
        int count = productDao.count();
        Assert.assertEquals(7,count);
    }

    @Test
    public void findMapList() {
        List<Map<String, Object>> mapLists = productDao.findMapList();
        for (Map<String, Object> map : mapLists){
            for (Map.Entry<String,Object> entry : map.entrySet()) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
            }
        }

    }
}