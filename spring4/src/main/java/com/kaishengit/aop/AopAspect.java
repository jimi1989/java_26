package com.kaishengit.aop;

import org.aspectj.lang.JoinPoint;

/**
 * aop 通知类
 * @author jinjianghao
 * @date 2018/7/16
 */
public class AopAspect {

    public void beforeAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] objs = joinPoint.getArgs();

        Object object = joinPoint.getTarget();
        System.out.println(object.getClass().getName());

        System.out.println(methodName);

        System.out.println("前置通知");
    }

    public void afterAdvice() {
        System.out.println("后置通知");
    }

    public void exceptionAdvice() {
        System.out.println("异常通知");
    }

    public void finallyAdvice() {
        System.out.println("最终通知");
    }

}
