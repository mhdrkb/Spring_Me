package com.mhd.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanConfig.xml");
        Student student = (Student) context.getBean("student");
        StudentDetails studentDetails = (StudentDetails) context.getBean("stu");
        studentDetails.callStudentmethod();
    }
}
