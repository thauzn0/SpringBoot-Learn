package com.luv2code.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HelloWorldController {

    // new a controller method to show initial html form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // need a controller method to process html form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // need a controller method to read form data and add data to model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // convert the data to all caps
        theName = theName.toUpperCase();
        // create the msg
        String result = "Yo!"  + theName;
        // add msg to model
        model.addAttribute("message", result);


        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName")String name,
                                          Model model){

        // read the request parameter from the HTML form

        // convert the data to all caps
        name = name.toUpperCase();
        // create the msg
        String result = "Hey my friend from v3!"  + name;
        // add msg to model
        model.addAttribute("message", result);


        return "helloworld";
    }
}
