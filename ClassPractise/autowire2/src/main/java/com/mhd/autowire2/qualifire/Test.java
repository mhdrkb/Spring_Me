package com.mhd.autowire2.qualifire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.mhd.autowire2.qualifire");
        context.refresh();
        VehicleService serviceVehicle = context.getBean(VehicleService.class);
        serviceVehicle.service();

        context.close();
    }
}
