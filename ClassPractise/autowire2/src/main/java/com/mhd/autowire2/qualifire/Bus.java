package com.mhd.autowire2.qualifire;

import org.springframework.stereotype.Component;

@Component(value = "busBean")
public class Bus implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Drive a Bus........");
    }

    @Override
    public void stop() {
        System.out.println("Stop a Bus........");
    }
}
