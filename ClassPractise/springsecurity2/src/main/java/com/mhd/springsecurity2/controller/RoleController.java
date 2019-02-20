package com.mhd.springsecurity2.controller;

import com.mhd.springsecurity2.entity.Role;
import com.mhd.springsecurity2.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/role/")
public class RoleController {
    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/role-list")
    public String roleList(Model model) {
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "role/role-list";
    }


    @GetMapping("/add-role")
    public String role(Role role) {
        return "role/add-role";
    }

    @PostMapping("/add-role")
    public String saveRole(@Valid Role role, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "role/add-role";
        } else {
            if (role != null) {
                Role role1 = this.roleRepo.findByRoleName(role.getRoleName());
                if (role1 != null) {
                    model.addAttribute("existMsg", "RoleName ALready Exist");
                } else {
                    role.setRoleName(role.getRoleName().toUpperCase());
                    this.roleRepo.save(role);
                    model.addAttribute("role", new Role()); //to clear the form after successfully reloading
                    model.addAttribute("successMsg", "Congratulations you have successfully saved Role data....");
                }
            }
        }
        return "role/add-role";
    }


    @GetMapping("/edit-role/{id}")
    public String roleEdit(@PathVariable("id") Long id, Model model, Role role) {
        model.addAttribute("role", this.roleRepo.getOne(id));
        return "role/edit-role";
    }

    @PostMapping("/edit-role/{id}")
    public String editRole(@Valid Role role, @PathVariable("id") Long id, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "role/edit-role";
        } else {
            if (role != null) {
                Role role1 = this.roleRepo.findByRoleName(role.getRoleName());
                if (role1 != null) {
                    model.addAttribute("existMsg", "RoleName ALready Exist");
                    return "role/edit-role";
                } else {
                    role.setRoleName(role.getRoleName().toUpperCase());
                    this.roleRepo.save(role);
                    model.addAttribute("role", new Role()); //to clear the form after successfully reloading
                    model.addAttribute("successMsg", "Congratulations you have successfully saved Role data....");
                }
            }
        }
        return "redirect: /role-list";
    }

    @GetMapping(value = "/del-role/{id}")
    public String delRole(@PathVariable("id") Long id) {
        this.roleRepo.deleteById(id);
        return "redirect: /role-list";
    }
//    @GetMapping(value = "/role-save") //HIT JUST ONE TIME AND SAVE THE ROLES INTO DATABASE
//    public String saveRole() {
//        Role role = new Role();
//        role.setRoleName("SUPERADMIN");
//        roleRepo.save(role);
//
//        Role role1= new Role();
//        role1.setRoleName("ADMIN");
//        roleRepo.save(role1);
//
//        Role role2 = new Role();
//        role2.setRoleName("USER");
//        roleRepo.save(role2);
//
//        return "success";
//
//    }
}
