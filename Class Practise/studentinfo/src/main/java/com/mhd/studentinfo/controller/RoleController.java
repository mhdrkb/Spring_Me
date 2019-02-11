package com.mhd.studentinfo.controller;

import com.mhd.studentinfo.entity.Role;
import com.mhd.studentinfo.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;


    @GetMapping(value = "/roleHome")
    public String roleHome(Model model) {
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "roleHome";
    }

    @GetMapping("/role")
    public String role(Role role) {
        return "add-role";
    }

    @PostMapping("/role")
    public String saveRole(@Valid Role role, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add-role";
        } else {
            this.roleRepo.save(role);
            model.addAttribute("role", new Role()); //to clear the form after successfully reloading
            model.addAttribute("successMsg", "Congratulations you have successfully saved Role data....");
        }
        return "add-role";
    }

    @GetMapping(value = "/roleDel/{id}")
    public String delRole(@PathVariable("id") Long id) {
        if (id != null) {
            this.roleRepo.deleteById(id);
        }
        return "redirect:/roleHome";
    }

    @GetMapping("/edit-role/{id}")
    public String editView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("student", this.roleRepo.getOne(id));
        return "edit-role";
    }
    @PostMapping("/edit-role/{id}")
    public String edit(@Valid Role role, BindingResult bindingResult, Model model, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "edit-role";
        }
        this.roleRepo.save(role);

        return "redirect:/roleHome";
    }
}
