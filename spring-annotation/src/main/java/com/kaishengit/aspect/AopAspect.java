package com.kaishengit.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author jinjianghao
 * @date 2018/7/16
 */
/*@Component("aopAspect")
@Aspect*/
public class AopAspect {

    @Pointcut("execution(* com.kaishengit.service..*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "马上要执行了..");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterAdvice(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "已经执行了..");
        System.out.println("return:" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "抛异常了.." + ex.getMessage());
    }

    @After("pointCut()")
    public void finallyAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "最终都要执行的..");
    }

    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;

        System.out.println("------------------");
        try {
            result = proceedingJoinPoint.proceed();
            System.out.println("===================");
        }catch (Throwable throwable) {
            System.out.println("++++++++++++++++++++++++");
        } finally {
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");
        }
        return result;
    }
}
