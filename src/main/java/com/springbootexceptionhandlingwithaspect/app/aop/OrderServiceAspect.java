package com.springbootexceptionhandlingwithaspect.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderServiceAspect {

    @Before(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.OrderService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("OrderServiceAspect | Before OrderService method got called");
    }

    @After(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.OrderService.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("OrderServiceAspect | After OrderService method got called");
    }

    @AfterReturning(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.OrderService.*(..))")
    public void afterReturningAdvice(JoinPoint joinPoint){
        System.out.println("OrderServiceAspect | AfterReturning OrderService method got called");
    }
}
