package com.kaishengit.proxy;

/**
 * @author jinjianghao
 * @date 2018/7/14
 */
public class Proxy implements Sale {
    private Sale sale;

    public Proxy(Sale sale) {
        this.sale = sale;
    }

    @Override
    public void salePc() {
        System.out.println("加价500元...");
        sale.salePc();
        System.out.println("一套鼠标键盘200元");
        System.out.println("送鼠标垫..");
    }

    @Override
    public int salePrice() {
        return 0;
    }
}
