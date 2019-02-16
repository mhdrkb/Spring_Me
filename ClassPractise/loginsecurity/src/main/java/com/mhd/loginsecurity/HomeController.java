package com.mhd.loginsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/login"})
    public String index(){
        return "login";
    }
    @GetMapping("/user/u")
    public String user(){
        return "user/user";
    }
    @GetMapping("/admin/h")
    public String home(){
        return "admin/home";
    }
    @GetMapping("/public/r")
    public String regi(){
        return "public/regi";
    }
    @GetMapping("/secure/s")
    public String secure(){
        return "secure/service";
    }
}
