package com.williamotzoy.kinalapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MenuViewController {

    @GetMapping("/menu-principal")
    public String menu() {
        return "index";
    }
}
