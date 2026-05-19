package com.williamotzoy.kinalapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuViewController {

    @GetMapping("/")
    public String menu() {
        return "index";
    }
}
