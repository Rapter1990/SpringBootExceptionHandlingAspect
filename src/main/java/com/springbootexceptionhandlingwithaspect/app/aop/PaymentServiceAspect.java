package com.springbootexceptionhandlingwithaspect.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PaymentServiceAspect {

    @Before(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.PaymentService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("PaymentServiceAspect | Before PaymentService method got called");
    }

    @After(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.PaymentService.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("PaymentServiceAspect | After PaymentService method got called");
    }

    @AfterReturning(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.PaymentService.*(..))")
    public void afterReturningAdvice(JoinPoint joinPoint){
        System.out.println("PaymentServiceAspect | AfterReturning PaymentService method got called");
    }
}
