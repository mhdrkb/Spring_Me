package com.mhd.diannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean(name = "stu")
    public Student getStudent() {
        Student student = new Student(100, "Mehedee");
        return student;
    }

    @Bean(name = "stu2")
    public Student getStudentBySetter() {
        Student student = new Student();
        student.setId(500);
        student.setName("Hasan");
        return student;
    }
}
