package com.mhd.hellomvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping(value = "/")
    public String home(){
        return "Hello MVC";
    }
    @GetMapping(value = "/test")
    public String test(){
        return "Hello Test";
    }
}
