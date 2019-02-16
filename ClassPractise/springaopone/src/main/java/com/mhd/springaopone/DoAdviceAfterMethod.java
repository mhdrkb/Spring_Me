package com.mhd.springaopone;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class DoAdviceAfterMethod implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("****SPRING AOP Advice After**** AfterMethodAdvice : Executing after the methods i created!!!!!!");
    }
}
