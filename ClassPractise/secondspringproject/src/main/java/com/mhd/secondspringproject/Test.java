package com.mhd.secondspringproject;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        Address address = (Address) factory.getBean("address"); //inside the getBean that is bean id of the xml class
        System.out.println(address);

        Student std= (Student) factory.getBean("student");
        System.out.println(std);
    }
}
