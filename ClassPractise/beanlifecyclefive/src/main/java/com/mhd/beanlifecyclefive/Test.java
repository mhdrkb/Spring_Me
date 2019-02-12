package com.mhd.beanlifecyclefive;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beanConfig.xml");
        context.getBean("myAwareService", MyAwareService.class);
        context.close();
    }
}
