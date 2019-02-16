package com.mhd.springaopone;

import org.springframework.aop.ThrowsAdvice;

public class DoAfterThowingException implements ThrowsAdvice {
    public void afterThrowing(IllegalArgumentException e) throws Throwable{
        System.out.println("****AOP advice after throwing Exception****  : Executing when method throws exception!!!!");
    }
}
