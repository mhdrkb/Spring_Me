package com.mhd.beanlifecycletwo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean, DisposableBean {
    private  long id;
    private String position;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
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

    @Override
    public void destroy() throws Exception {
        System.out.println("I am in destroy....");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("I am in initialize...");

    }
}
//when a bean class implements the InitializingBean interface it is allowed to perform initialization work after all necessary property