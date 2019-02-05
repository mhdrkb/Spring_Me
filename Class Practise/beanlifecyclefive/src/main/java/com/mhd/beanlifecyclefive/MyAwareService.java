package com.mhd.beanlifecyclefive;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;

public class MyAwareService implements ApplicationContextAware, ApplicationEventPublisher,
        BeanClassLoaderAware, BeanFactoryAware, BeanNameAware, EnvironmentAware,
        ImportAware, ResourceLoader {
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader Called: ");
        System.out.println("setBeanClassLoader:: Class Loader Name = " + classLoader.getClass().getName());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory Called: ");
        System.out.println("setBeanFactory:: employee bean singleton = " + beanFactory.isSingleton("empoi"));
        System.out.println("setBeanFactory:: employee1 bean singleton = " + beanFactory.isSingleton("empoi1"));
        System.out.println("setBeanFactory:: employee2 bean singleton = " + beanFactory.isSingleton("empoi2"));
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("setBeanName Called: ");
        System.out.println("setBeanName:: Bean name name defined in context = " + beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        System.out.println("setApplicationContext called: ");
        System.out.println("applicationContext:: BeanClassLoaderAware Definition name = " + Arrays.toString(context.getBeanDefinitionNames()));
    }

    @Override
    public void publishEvent(Object o) {
        System.out.println("publishEvent Called: ");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("setEnvironment Called: ");
    }

    @Override
    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        System.out.println("setImportMetadata called: ");

    }

    @Override
    public Resource getResource(String s) {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }
}
