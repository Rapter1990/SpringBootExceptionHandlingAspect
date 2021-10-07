package com.springbootexceptionhandlingwithaspect.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductServiceAspect {

    @Before(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.ProductService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("CategoryServiceAspect | Before ProductService method got called");
    }

    @After(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.ProductService.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("CategoryServiceAspect | After ProductService method got called");
    }

    @AfterReturning(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.ProductService.*(..))")
    public void afterReturningAdvice(JoinPoint joinPoint){
        System.out.println("CategoryServiceAspect | AfterReturning ProductService method got called");
    }
}
