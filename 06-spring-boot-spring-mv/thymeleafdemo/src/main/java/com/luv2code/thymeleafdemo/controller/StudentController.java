package com.luv2code.thymeleafdemo.controller;

import com.luv2code.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;
    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model model){

        // create a new student obj
        Student student = new Student();
        // add student obj to model
        model.addAttribute("student", student);
        // add the list of countries to model
        model.addAttribute("countries", countries);
        // add list of programming languages
        model.addAttribute("languages", languages);
        // add list of systems
        model.addAttribute("systems", systems);

        return "student-form";
    }


    @PostMapping("/processStudentForm")
    public  String processForm(@ModelAttribute("student") Student student){

        // log the data
        System.out.println("Student:" + student.getFirstName()  + " " + student.getLastName() + " "
                +  student.getCountry() + " " + student.getFavoriteLanguage()
                + " " + student.getFavoriteSystems()
        );

        return "student-confirmation";
    }





}
