package com.kaishengit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * aop 通知类
 * @author jinjianghao
 * @date 2018/7/16
 */
public class AopAspect {

    public void beforeAdvice(JoinPoint joinPoint) {
        /*String methodName = joinPoint.getSignature().getName();
        Object[] objs = joinPoint.getArgs();

        Object object = joinPoint.getTarget();
        System.out.println(object.getClass().getName());

        System.out.println(methodName);*/

        System.out.println("前置通知");
    }

    public void afterAdvice(Object result) {
        System.out.println("后置通知,result-->" + result);
    }

    public void exceptionAdvice(Exception ex) {
        System.out.println("异常通知, exception-->" +  ex.getMessage());
    }

    public void finallyAdvice() {
        System.out.println("最终通知");
    }

    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("-----------------");
        Object result = null;
        try {
            // 目标方法的执行
            result = proceedingJoinPoint.proceed();
            System.out.println("+++++++++++++++++");

        } catch (Throwable e) {
            System.out.println("=================");
        } finally {
            System.out.println("^^^^^^^^^^^^^^^^^");
        }
        return result;
    }

}
