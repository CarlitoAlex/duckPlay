package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorControllers {

    @GetMapping("/accessDenied")
    public String getDeniedPage(){
        return "403";
    }
}
