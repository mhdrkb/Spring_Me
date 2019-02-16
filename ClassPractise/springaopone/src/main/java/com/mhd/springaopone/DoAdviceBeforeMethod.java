package com.mhd.springaopone;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class DoAdviceBeforeMethod implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable{
        System.out.println("****SPRING AOP Advice**** DoBeforeMethod : Executing before the methods i created!!!!!!");
    }
}
