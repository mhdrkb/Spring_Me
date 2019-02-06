package com.mhd.autowire2.bean.scope.singleton;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "sigleton")
public class AA {
    public AA() {
        System.out.println("Singletone object created...");
    }
}
