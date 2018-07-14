package com.kaishengit.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author jinjianghao
 * @date 2018/7/14
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        /**
         *  proxy : 没有任何作用
         *  method: 目标对象的方法的详情对象，通过反射机制调用invoke方法运行该方法
         *  args: 目标方法执行时的参数列表
         *
         */
        System.out.println("-------------------");
        Object result = method.invoke(target, args);
        System.out.println("===================");

        return result;
    }
}
