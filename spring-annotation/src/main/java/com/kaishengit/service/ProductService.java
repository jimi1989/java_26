package com.kaishengit.service;

import com.kaishengit.dao.ProductDao;
import com.kaishengit.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/7/17
 */
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional(rollbackFor = Exception.class)
    public void batchSave(List<Product> productList) throws Exception{
        for(Product product : productList) {
            productDao.save(product);
            // throw new Exception();
        }
    }



}
