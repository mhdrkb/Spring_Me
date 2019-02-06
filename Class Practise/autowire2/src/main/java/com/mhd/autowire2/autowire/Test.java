package com.mhd.autowire2.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context =new AnnotationConfigApplicationContext(TestConfig.class);
        Student student = context.getBean(Student.class);
        student.showDetails();
    }
}
