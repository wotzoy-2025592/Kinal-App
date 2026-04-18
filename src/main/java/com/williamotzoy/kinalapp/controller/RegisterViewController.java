package com.williamotzoy.kinalapp.controller;

import com.williamotzoy.kinalapp.entity.Usuario;
import com.williamotzoy.kinalapp.service.IUsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/registro")
public class RegisterViewController {

    private final IUsuarioService usuarioService;

    public RegisterViewController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("rolActual", "ADMIN");
        return "register";
    }

    @PostMapping("/añadir")
    public String guardar(@ModelAttribute Usuario usuario) {
        usuarioService.guardar(usuario);
        return "redirect:/login";
    }

}
