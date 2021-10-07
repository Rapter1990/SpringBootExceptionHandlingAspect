package com.springbootexceptionhandlingwithaspect.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CategoryServiceAspect {

    @Before(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.CategoryService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("CategoryServiceAspect | Before CategoryService method got called");
    }

    @After(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.CategoryService.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("CategoryServiceAspect | After CategoryService method got called");
    }

    @AfterReturning(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.CategoryService.*(..))")
    public void afterReturningAdvice(JoinPoint joinPoint){
        System.out.println("CategoryServiceAspect | AfterReturning CategoryService method got called");
    }
}
