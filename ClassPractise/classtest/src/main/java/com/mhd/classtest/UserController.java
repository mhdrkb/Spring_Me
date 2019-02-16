package com.mhd.classtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    @GetMapping("/")
    public String userList(Model model) {
        model.addAttribute("list", this.userRepo.findAll());
        return "index";
    }

    @GetMapping("/add-user")
    public String addUser(User user, Model model) {
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "add-page";
    }
    @PostMapping("/add-user")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "add-page";
        }else {
            this.userRepo.save(user);
            model.addAttribute("user",new User());
            model.addAttribute("roleList", this.roleRepo.findAll());
            model.addAttribute("successMsg","Congrtulations ..! Successfully saved data");
        }
        return "add-page";
    }


    @GetMapping("/edit-user/{id}")
    public String editView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", this.userRepo.getOne(id));
        return "edit-page";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid User user, BindingResult bindingResult, @PathVariable("id") Long id) {

        if (bindingResult.hasErrors()) {
            return "edit-page";
        }
        this.userRepo.save(user);
        return "redirect:/";
    }


    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.userRepo.deleteById(id);
        }
        return "redirect:/";
    }
}
