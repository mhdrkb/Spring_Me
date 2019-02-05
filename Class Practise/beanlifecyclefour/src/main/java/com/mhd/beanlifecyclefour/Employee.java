package com.mhd.beanlifecyclefour;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee {
    private  long id;
    private String position;

    public void setId(long id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", position='" + position + '\'' +
                '}';
    }
    @PostConstruct
    void initIt(){
        System.out.println("I am initilized...");
    }
    @PreDestroy
    void cleanUp(){
        System.out.println("I am destroyed....");
    }
}
