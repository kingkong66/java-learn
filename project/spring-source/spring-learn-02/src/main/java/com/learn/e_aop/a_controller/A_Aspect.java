package com.learn.e_aop.a_controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class A_Aspect {

    @Pointcut("execution(* com.learn.e_aop.a_service..*.*(..))")
    public void embed(){}

    @Before("embed()")
    public void before(JoinPoint joinpoint){
        System.out.println("#####before###"+joinpoint);
    }

    @After("embed()")
    public void after(JoinPoint joinpoint){
        System.out.println("#####after###"+joinpoint);
    }

    @Around("embed()")
    public Object around(JoinPoint joinpoint){
        System.out.println("#####around--start###"+joinpoint);
        Object returnValue = null;
        try {
            returnValue = ((ProceedingJoinPoint) joinpoint).proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("#####around--end###"+joinpoint);
        return returnValue;
    }

    @AfterReturning(pointcut = "embed()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue){
        System.out.println("#####afterReturning###"+joinPoint+"，###returnValue###"+returnValue);
    }

    @AfterThrowing(pointcut = "embed()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception){
        System.out.println("#####afterThrowing###"+joinPoint+"，###throw exception###"+exception);
    }

}
