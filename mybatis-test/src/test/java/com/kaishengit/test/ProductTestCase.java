package com.kaishengit.test;

import com.kaishengit.entity.Product;
import com.kaishengit.util.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/7/9
 */
public class ProductTestCase {

    @Test
    public void testSave() throws IOException {

        // 1.读取mybatis主配置文件
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        // InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        // 2.创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        //3. 创建sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //  非自动提交！

        // 4.操作数据库
        Product product = new Product();
        product.setProductName("iphone X");
        product.setProductInventory(200);

        int res = sqlSession.insert("com.kaishengit.mapper.ProductMapper.save", product);

        // 4.1 自动提交事务
        // sqlSession.commit();

        Assert.assertEquals(1, res);

        // 5.释放资源
        sqlSession.close();
    }

    @Test
    public void testFindAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Product> productList = sqlSession.selectList("com.kaishengit.mapper.ProductMapper.findAll");

        for(Product product : productList) {
            System.out.println(product);
        }

        sqlSession.close();
    }

    @Test
    public void testFindOne() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        Product product = sqlSession.selectOne("com.kaishengit.mapper.ProductMapper.findById", 4);
        System.out.println(product);
        sqlSession.close();
    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        sqlSession.delete("com.kaishengit.mapper.ProductMapper.deleteById", 7);
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = MybatisUtils.getSqlSession(true);

        Product product = sqlSession.selectOne("com.kaishengit.mapper.ProductMapper.findById", 5);

        product.setProductName("iphone x 2s");
        product.setProductInventory(300);

        sqlSession.update("com.kaishengit.mapper.ProductMapper.update", product);
        sqlSession.close();
    }

}


