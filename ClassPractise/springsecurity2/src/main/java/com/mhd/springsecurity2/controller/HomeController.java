package com.mhd.springsecurity2.controller;

import com.mhd.springsecurity2.entity.User;
import com.mhd.springsecurity2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/u")
    public String userView(){
        return "add-user";
    }


    @GetMapping("/adm")
    public String adminView(){
        return "admin/admin";
    }


    @GetMapping("/sa")
    public String superAdmin(){
        return "sadmin/sad";
    }

    @GetMapping("/off")
    public String officerView(){
        return "sadmin/sad";
    }

    @GetMapping("/sec")
    public String secure(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username",auth.getName());
        User user = userRepo.findByUserName(auth.getName());
        model.addAttribute("name",user.getName());
        return "secure/secure";
    }

}
