package com.kaishengit.mapper;

import com.kaishengit.BaseTestCase;
import com.kaishengit.entity.Kaola;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @author jinjianghao
 * @date 2018/7/19
 */
public class KaolaMapperTestCase extends BaseTestCase {

    @Autowired
    private KaolaMapper kaolaMapper;

    @Test
    public void testFindById() {
        Kaola kaola =  kaolaMapper.selectByPrimaryKey(2177);
        System.out.println(kaola);
    }

    @Test
    public void testSave() {
        Kaola kaola = new Kaola();
        kaola.setProductName("谢霆锋同款T恤 潮流 明星同款");
        kaola.setCommentNum(1000);
        kaola.setMarketPrice(new BigDecimal(299.99));
        kaola.setPrice(new BigDecimal(199.99));
        kaola.setPlace("hk");
        kaola.setTypeId(12);

        kaolaMapper.insert(kaola);
        // 获得自动增长的id
        int id = kaola.getId();
        System.out.println("id:" + id);
    }


}
