package com.mhd.diannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Student student = (Student) context.getBean("stu");
        System.out.println(student);

        Student student1 = (Student) context.getBean("stu2");
        System.out.println(student1);
    }
}
