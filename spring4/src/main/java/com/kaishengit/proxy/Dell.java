package com.kaishengit.proxy;

/**
 * @author jinjianghao
 * @date 2018/7/14
 */
public class Dell implements Sale{

    @Override
    public void salePc() {
        System.out.println("戴尔厂商销售电脑一台");
    }
}
