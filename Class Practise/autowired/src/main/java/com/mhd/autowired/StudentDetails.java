package com.mhd.autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class StudentDetails {
    public StudentDetails() {
        System.out.println("Studentd Details connnnnnn..........");
    }

    @Autowired
    private Student student;
    public void callStudentmethod() {
        student.display();
    }
}
