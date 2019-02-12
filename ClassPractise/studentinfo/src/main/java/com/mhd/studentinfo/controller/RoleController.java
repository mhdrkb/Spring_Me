package com.mhd.studentinfo.controller;

import com.mhd.studentinfo.entity.Role;
import com.mhd.studentinfo.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;



    @GetMapping(value = "/role-list")
    public String roleHome(Model model) {
        model.addAttribute("rolelist", this.roleRepo.findAll());
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
            if(role != null){
                Role role1 = this.roleRepo.findByRoleName(role.getRoleName());
                if (role1 != null){
                    model.addAttribute("existMsg","RoleName ALready Exist");
                }else{
                    this.roleRepo.save(role);
                    model.addAttribute("role", new Role()); //to clear the form after successfully reloading
                    model.addAttribute("successMsg", "Congratulations you have successfully saved Role data....");
                }
            }
        }
        return "role/add-role";
    }




//    @GetMapping(value = "/roleDel/{id}")
//    public String delRole(@PathVariable("id") Long id) {
//        if (id != null) {
//            this.roleRepo.deleteById(id);
//        }
//        return "redirect:/role-list";
//    }





    @GetMapping("/edit-role/{id}")
    public String editView( @PathVariable("id") Long id,Model model) {
        model.addAttribute("role", this.roleRepo.getOne(id));
        return "role/edit-role";
    }
    @PostMapping("/edit-role/{id}")
    public String edit(@Valid Role role, BindingResult bindingResult, Model model, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "role/edit-role";
        }else{
            if (role != null){
                Role role2 = this.roleRepo.findByRoleName(role.getRoleName());
                if (role2 != null){
                    model.addAttribute("existMsg","RoleName Already Exist");
                    return "role/edit-role";
                }else {
                    this.roleRepo.save(role);
                    model.addAttribute("role",new Role());
                    model.addAttribute("successMsg","Successfully saved Role data");
                }
            }
        }
        return "redirect:/role-list";
    }

@RequestMapping(value = "/role-del/{id}",method = RequestMethod.GET)
    public String delRole(@PathVariable("id") Long id){
        this.roleRepo.deleteById(id);
        return "redirect:/role-list";

    }
}
