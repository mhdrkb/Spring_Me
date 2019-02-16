package com.mhd.springaopone;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee simpleService = (Employee) context.getBean("proxyFactoryBean");
        simpleService.printNameId();
        System.out.println("-------------\n");
        System.out.println("------this method  do not get any exception so it execute simuteniously, no exception msg will not show, but the doAfterAdvice msg will show as the methods executes-------");
        try{
            simpleService.checkName();
        }catch (Exception e){
            System.out.println("Employee: Method checkName() exception thrown.......");
        }
        System.out.println("------------------------------\n");

        System.out.println("--------------This method may have exception so the DoAdviceAfterMethod message will not show----------------");
        try{
            simpleService.checkMsg();
        }catch (Exception e){
            System.out.println("Employee: Method checkMsg() exception thrown.......");
        }
        System.out.println("-------------------\n");
        simpleService.sayHello("Good Morning Programmer.........");
        context.close();

    }
}
