package com.mhd.springsecurity2.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {


//    @GetMapping(value = {"/", "/login"})
//    public String index(){
//        return "login";
//    }
    @RequestMapping(value = {"/login","/"}, method = RequestMethod.GET)
    public String login(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)){
            return "redirect:/sec";
        }
        return "public/login";
    }

    @GetMapping(value = "/access-denied")
    public String accessDenied(){
        return "access-denied";
    }

}
