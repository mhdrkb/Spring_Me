package com.mhd.beanlifecyclethree;

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

    void initIt(){
        System.out.println("I am initilized...");
    }
    void cleanUp(){
        System.out.println("I am destroyed....");
    }
}
