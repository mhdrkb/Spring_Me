package com.mhd.springsecurity2.controller;

import com.mhd.springsecurity2.entity.Role;
import com.mhd.springsecurity2.entity.User;
import com.mhd.springsecurity2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping(value = "/user-save") //HIT JUST ONE TIME AND SAVE THE ROLES INTO DATABASE
    public String saveRole() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1L));
        roles.add(new Role(3L));
        User user = new User("mhd", passwordEncoder.encode("1234"), "mhd@gmail.com", "Mehedee", true, roles);
        userRepo.save(user);

        Set<Role> roles2 = new HashSet<>();
        roles2.add(new Role(2L));
        User user2 = new User("hsn", passwordEncoder.encode("1234"), "hsn@gmail.com", "Hasan", true, roles2);
        userRepo.save(user2);

        Set<Role> roles3 = new HashSet<>();
        roles3.add(new Role(3L));
        User user3 = new User("rkb", passwordEncoder.encode("1234"), "rkb@gmail.com", "Rakib", true, roles3);
        userRepo.save(user3);
        return "success";
    }
}
