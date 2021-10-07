package com.springbootexceptionhandlingwithaspect.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderItemServiceAspect {

    @Before(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.OrderItemService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("OrderItemServiceAspect | Before OrderItemService method got called");
    }

    @After(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.OrderItemService.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("OrderItemServiceAspect | After OrderItemService method got called");
    }

    @AfterReturning(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.OrderItemService.*(..))")
    public void afterReturningAdvice(JoinPoint joinPoint){
        System.out.println("OrderItemServiceAspect | AfterReturning OrderItemService method got called");
    }
}
