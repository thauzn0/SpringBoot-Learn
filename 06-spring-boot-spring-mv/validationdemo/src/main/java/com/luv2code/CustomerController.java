package com.luv2code.springdemo.mvc;

import com.luv2code.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String showForm(Model theModel) {

        theModel.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult theBindingResult) {
        System.out.println("Last name: | " + theCustomer.getLastName() + "|");
        if (theBindingResult.hasErrors()) {
            return "customer-form";
        }
        else {
            return "customer-confirmation";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        // creating new string trimmer editor object // removing whitespace - leading and trailing // true means trim not null
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        // registering our string trimmer editor
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}






