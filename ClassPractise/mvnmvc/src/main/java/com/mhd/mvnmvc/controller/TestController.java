package com.mhd.mvnmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/tt")
    public  String test(@RequestParam(value = "ms", required = true, defaultValue = "Helloooooo") String msg){
        return msg;
    }
    @GetMapping(value = "/ttt")
    public  String test1(@RequestParam(value = "ms") String msg){
        return msg;
    }

}
