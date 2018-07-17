package com.kaishengit.service;

import com.kaishengit.BaseTestCase;
import com.kaishengit.entity.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jinjianghao
 * @date 2018/7/17
 */
public class ProductServiceTest extends BaseTestCase {

    @Autowired
    private ProductService productService;

    @Test
    public void batchSave() throws Exception{
        Product product = new Product();
        product.setProductName("罗技鼠标");
        product.setProductInventory(100);

        Product product1 = new Product();
        product1.setProductName(null);
        product1.setProductInventory(100);

        List<Product> productList = Arrays.asList(product, product1);
        productService.batchSave(productList);


    }
}