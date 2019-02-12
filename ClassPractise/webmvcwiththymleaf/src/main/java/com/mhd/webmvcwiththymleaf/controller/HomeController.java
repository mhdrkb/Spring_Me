package com.mhd.webmvcwiththymleaf.controller;

import com.mhd.webmvcwiththymleaf.entity.User;
import com.mhd.webmvcwiththymleaf.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class HomeController {

    @Autowired
    private UserRepo repo;

    @GetMapping(value = "/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        //mv.addObject("title", "Home ! CompanyName Inc.");
        mv.addObject("user",new User());
        mv.setViewName("index");//as like your html file name
        return mv;
    }

    @PostMapping(value = "/")
    public ModelAndView aqdd(@Valid User user) {
        ModelAndView mv = new ModelAndView();
        if(user.getName() != null){
            this.repo.save(user);
            mv.addObject("successMsg", "Succesfully saved");
            mv.addObject("user", new User());
        }
        mv.setViewName("index");//as like your html file name
        return mv;
    }

}
