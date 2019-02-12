package com.mhd.webmvcwiththymeleaf2.controller;

import com.mhd.webmvcwiththymeleaf2.entity.User;
import com.mhd.webmvcwiththymeleaf2.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SaveController {

    @Autowired
    private Repo repo;



    @GetMapping(value = "/")
    public  String index(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "index";
    }




    @GetMapping("/add")
    public String showForm(User user) {
        return "add-page";
    }
    @PostMapping("/add")
    public String save(@Valid User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "add-page";
        }
        this.repo.save(user);
        model.addAttribute("user",new User()); //to clear the form after successfully reloading
        model.addAttribute("successMsg","Congratulations you are successfully saved data...."); //for showing message in this page
        //return "redirect:/result"; // for redirect to another page to show msg
        return "add-page";
    }




    @GetMapping(value = "/del/{id}")
    public  String delete(@PathVariable("id") Long id){
        if(id!=null){
            this.repo.deleteById(id);
            //model.addAttribute("delMsg","Deleted a User successfully");
        }
        return "redirect:/";
    }




    @GetMapping("/edit/{id}")
    public String editView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user",this.repo.findById(id));
        return "edit";
    }
    @PostMapping("/edit/{id}")
    public String edit(@Valid User user, BindingResult bindingResult, Model model, @PathVariable("id") Long id){
        if(bindingResult.hasErrors()){
            return "edit";
        }
        this.repo.save(user);
        model.addAttribute("user",new User()); //to clear the form after successfully reloading
        //model.addAttribute("successMsg","Congratulations you are successfully Edited data...."); //for showing message in this page
        //return "redirect:/result"; // for redirect to another page to show msg
        return "redirect:/"; //to go to index page,
        //return "edit"; //for saying in this page
    }




    
//    @GetMapping("/results")
//    public String showForm() {
//        return "/result";
//    }

//    @GetMapping(value = "/")
//    public ModelAndView save() {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("user", new User());
//        mv.setViewName("save");
//        return mv;
//    }
//
//    @PostMapping(value = "/")
//    public ModelAndView add(@Valid User user) {
//        ModelAndView mv = new ModelAndView();
//        if (user.getName() == null) {
//            this.repo.save(user);
//        }
//
//        return mv;
//    }


}
