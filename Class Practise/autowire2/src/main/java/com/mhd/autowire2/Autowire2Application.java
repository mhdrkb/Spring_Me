package com.mhd.autowire2;

import com.mhd.autowire2.autowire.Student;
import com.mhd.autowire2.context.Vehicle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Autowire2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context1 = SpringApplication.run(Autowire2Application.class, args);

        System.out.println("Autowired example started.....");
        Student std=context1.getBean(Student.class);
        std.showDetails();
        System.out.println("Autowired example ended.....");

        ApplicationContext context = new ClassPathXmlApplicationContext("configSpring.xml");
        System.out.println("Vehicle Factory pattern example started.....");
        Vehicle vc = (Vehicle) context.getBean("vehicle");
        vc.drive();
        Vehicle vc1 = (Vehicle) context.getBean("vehicle1");
        vc1.drive();
        System.out.println("Vehicle Factory pattern example ended.....");
    }

}

