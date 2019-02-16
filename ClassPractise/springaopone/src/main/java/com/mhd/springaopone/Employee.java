package com.mhd.springaopone;

public class Employee {
    private int id;
    private String name;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void printNameId() {
        System.out.println("SimpleService: Method printNameId() : My name is " + name + " and my id is " + id + " and the message is " + msg);
    }


    public void checkName() {
        if (name.length() < 20) {
            throw new IllegalArgumentException();
        }
    }

    public void checkMsg() {
        if (msg.length() < 40) {
            throw new IllegalArgumentException();
        }
    }


    public void sayHello(String message) {
        System.out.println("SimpleService : Method sayHello() : message is: " + message);
    }
}
