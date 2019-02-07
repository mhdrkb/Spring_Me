package com.mhd.mvnmvc.controller;

import com.mhd.mvnmvc.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {
    @GetMapping(value = "/")
    public String home(){
        return "Hello.........";
    }

    @GetMapping(value = "/test")
    public String test(){
        return "Test..........";
    }

    public List<User> getList(){
        List<User> list = new ArrayList<>();
        list.add(new User(1L,"mhd","021725683"));
        list.add(new User(1L,"hsn","546545555"));
        list.add(new User(1L,"rkb","021615874"));
        return list;
    }
}
