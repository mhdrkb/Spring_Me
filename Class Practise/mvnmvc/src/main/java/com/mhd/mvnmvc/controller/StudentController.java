package com.mhd.mvnmvc.controller;

import com.mhd.mvnmvc.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    static List<Student> list;

    static {
        list = new ArrayList<>();
        list.add(new Student(1L, "Mehedee", "Mohammadpur"));
        list.add(new Student(2L, "Hasan", "Dhanmondi"));
        list.add(new Student(3L, "Rakib", "Zigatola"));
        list.add(new Student(4L, "Hridoy", "Badda"));
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> getList() {
        return this.list;
    }

}
