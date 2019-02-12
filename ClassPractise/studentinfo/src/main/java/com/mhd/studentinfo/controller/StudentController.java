package com.mhd.studentinfo.controller;


import com.mhd.studentinfo.entity.Student;
import com.mhd.studentinfo.imageoptimizer.ImageOptimizer;
import com.mhd.studentinfo.repository.RoleRepo;
import com.mhd.studentinfo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
public class StudentController {
    //to save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";

    @Autowired
    private ImageOptimizer imageOptimizer;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private StudentRepo repo;


    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("list", this.repo.findAll());
        this.repo.findAll().forEach((c) -> {
            System.out.println(c.toString());
        });
        return "index";
    }


    @GetMapping("/add")
    public String showForm(Student student, Model model) {
        model.addAttribute("roleList",this.roleRepo.findAll());
        return "add-page";
    }

    @PostMapping("/add")
    public String save(@Valid Student student, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            return "add-page";
        } else {
            student.setRegiDate(new Date());

            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                student.setFileName("new-" + file.getOriginalFilename());
                student.setFileSize(file.getSize());
                student.setFilePath("images/" + "new-" + file.getOriginalFilename());
                student.setFileExtesion(file.getContentType());

                this.repo.save(student);
                model.addAttribute("student", new Student()); //to clear the form after successfully reloading
                model.addAttribute("successMsg", "Congratulations you are successfully saved data...."); //for showing message in this page
                imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, .9f, 200, 100);
                //return "redirect:/result"; // for redirect to another page to show msg
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("roleList",this.roleRepo.findAll());
        return "add-page";
    }


    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.repo.deleteById(id);
            //model.addAttribute("delMsg","Deleted a Student successfully");
        }
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String editView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("student", this.repo.getOne(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid Student student, BindingResult bindingResult, Model model, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        this.repo.save(student);
        //model.addAttribute("student",new Student()); //to clear the form after successfully reloading
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
//        mv.addObject("student", new Student());
//        mv.setViewName("save");
//        return mv;
//    }
//
//    @PostMapping(value = "/")
//    public ModelAndView add(@Valid Student student) {
//        ModelAndView mv = new ModelAndView();
//        if (student.getName() == null) {
//            this.repo.save(student);
//        }
//
//        return mv;
//    }


}
