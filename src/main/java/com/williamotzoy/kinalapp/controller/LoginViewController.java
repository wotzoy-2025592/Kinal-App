package com.williamotzoy.kinalapp.controller;

import com.williamotzoy.kinalapp.entity.Usuario;
import com.williamotzoy.kinalapp.service.IUsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginViewController {

    private final IUsuarioService usuarioService;

    public LoginViewController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String loginPage() {
        return "login";
    }

    @GetMapping("/")
    public String menu(Model model){
        model.addAttribute("successmessage", "Conexión establecida con Éxito");
        return "index";
    }

}