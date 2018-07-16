package com.kaishengit.proxy;

import com.kaishengit.proxy.jdk.MyInvocationHandler;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;

/**
 * @author jinjianghao
 * @date 2018/7/14
 */
public class ProxyTestCase {

    @Test
    public void testProxy() {
        /*ProxyLenovo proxyLenovo = new ProxyLenovo();
        proxyLenovo.salePc();*/

       // Lenovo lenovo = new Lenovo();
        Dell dell = new Dell();
        Proxy proxy = new Proxy(dell);
        proxy.salePc();
    }


    @Test
    public void testDynamicProxy() {

        Dell dell = new Dell();

        // 创建MyInvocationHandler对象
        MyInvocationHandler invocationHandler = new MyInvocationHandler(dell);

        // 动态产生代理类对象
        Sale sale = (Sale) java.lang.reflect.Proxy.newProxyInstance(Dell.class.getClassLoader(),
                Dell.class.getInterfaces(),
                invocationHandler);

        // 获得类的完全限定名
        System.out.println(sale.getClass().getName());

        sale.salePc();

    }

}
