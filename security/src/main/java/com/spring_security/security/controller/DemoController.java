package com.spring_security.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/leaders")
    public String showleaders() {
        return "leaders";
    }

    @GetMapping("/systems")
    public String showsystems() {
        return "systems";
    }
}
