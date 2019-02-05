package com.mhd.autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
    public Student() {
        System.out.println("I am a student");
    }
    @Autowired
    public void display(){
        System.out.println("Hellloooo......");
    }
}
