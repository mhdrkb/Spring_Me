package com.mhd.springsecurity2.controller;

import com.mhd.springsecurity2.entity.Role;
import com.mhd.springsecurity2.entity.User;
import com.mhd.springsecurity2.repo.RoleRepo;
import com.mhd.springsecurity2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/add-user")
    public String showForm(User user, Model model) {
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "user/add-user";
    }

    @PostMapping("/add-user")
    public String save(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("roleList", this.roleRepo.findAll());
            return "user/add-user";
        } else {
            user.setPaswword(passwordEncoder.encode(user.getPaswword()));
            this.userRepo.save(user);
            model.addAttribute("user", new User()); //to clear the form after successfully reloading
            model.addAttribute("successMsg", "Congratulations you are successfully saved data...."); //for showing message in this page
        }
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "user/add-user";
    }

    @GetMapping(value = "/user-list")
    public String userList(Model model) {
        model.addAttribute("userList", this.userRepo.findAll());
        return "user/user-list";
    }


//    @GetMapping(value = "/user-save") //HIT JUST ONE TIME AND SAVE THE ROLES INTO DATABASE
//    public String saveRole() {
//        Set<Role> roles = new HashSet<>();
//        roles.add(new Role(1L));
//        roles.add(new Role(3L));
//        User user = new User("mhd", passwordEncoder.encode("1234"), "mhd@gmail.com", "Mehedee", true, roles);
//        userRepo.save(user);
//
//        Set<Role> roles2 = new HashSet<>();
//        roles2.add(new Role(2L));
//        User user2 = new User("hsn", passwordEncoder.encode("1234"), "hsn@gmail.com", "Hasan", true, roles2);
//        userRepo.save(user2);
//
//        Set<Role> roles3 = new HashSet<>();
//        roles3.add(new Role(3L));
//        User user3 = new User("rkb", passwordEncoder.encode("1234"), "rkb@gmail.com", "Rakib", true, roles3);
//        userRepo.save(user3);
//        return "success";
//    }
}
