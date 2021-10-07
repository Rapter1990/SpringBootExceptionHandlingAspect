package com.springbootexceptionhandlingwithaspect.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceAspect {

    @Before(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.UserService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("UserServiceAspect | Before UserService method got called");
    }

    @After(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.UserService.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("UserServiceAspect | After UserService method got called");
    }

    @AfterReturning(value="execution(* com.springbootexceptionhandlingwithaspect.app.service.UserService.*(..))")
    public void afterReturningAdvice(JoinPoint joinPoint){
        System.out.println("UserServiceAspect | AfterReturning UserService method got called");
    }
}
