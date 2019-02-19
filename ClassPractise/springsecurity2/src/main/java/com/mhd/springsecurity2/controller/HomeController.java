package com.mhd.springsecurity2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/u")
    public String userView(){
        return "user/u";
    }


    @GetMapping("/adm")
    public String adminView(){
        return "admin/admin";
    }


    @GetMapping("/sa")
    public String superAdmin(){
        return "sadmin/sad";
    }



    @GetMapping("/sec")
    public String secure(){
        return "secure/secure";
    }
}
