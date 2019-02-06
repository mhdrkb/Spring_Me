package com.mhd.autowire2.context;

public class Bus implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Drive a Bus........");
    }
}
