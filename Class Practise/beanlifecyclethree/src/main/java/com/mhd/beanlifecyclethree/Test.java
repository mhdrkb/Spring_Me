package com.mhd.beanlifecyclethree;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beanConfig.xml");
        Employee emp = (Employee) context.getBean("empo");
        System.out.println(emp.toString());
        context.close();
    }
}
