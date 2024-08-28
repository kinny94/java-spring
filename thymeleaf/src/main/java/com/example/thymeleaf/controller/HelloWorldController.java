package com.example.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public  String showForm() {
        return "HelloWorldForm";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloWorld";
    }

    @RequestMapping("/processForm2")
    public String customAttributesToModel(HttpServletRequest request, Model model) {
        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();
        String result = "Yo!..." + theName;
        model.addAttribute("message", result);
        return "helloworld";
    }

    @PostMapping("/processForm3")
    public String customAttributesToModelRequestBinding(@RequestParam("studentName") String theName, Model model) {
        theName = theName.toUpperCase();
        String result = "Hello from V3!..." + theName;
        model.addAttribute("message", result);
        return "helloworld";
    }
}
