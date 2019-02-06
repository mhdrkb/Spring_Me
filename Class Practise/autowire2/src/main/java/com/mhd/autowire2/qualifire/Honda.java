package com.mhd.autowire2.qualifire;

import org.springframework.stereotype.Component;

@Component(value = "hondaBean")
public class Honda implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Drive a honda.....");
    }

    @Override
    public void stop() {
        System.out.println("Stop a honda.....");
    }
}
