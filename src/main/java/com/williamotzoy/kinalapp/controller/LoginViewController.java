package com.williamotzoy.kinalapp.controller;

import com.williamotzoy.kinalapp.entity.Usuario;
import com.williamotzoy.kinalapp.service.IUsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
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

    @PostMapping
    public String login(@RequestParam String userName, @RequestParam String password, HttpSession session) {
        Usuario usuario = usuarioService.buscarPorNombre(userName)
                .orElse(null);
        if (usuario != null && usuario.getPassword().equals(password)) {
            session.setAttribute("usuarioLogueado", usuario);
            session.setAttribute("rolActual", usuario.getRol());
            session.setAttribute("usuarioId", usuario.getCodigoUsuario());
            return "redirect:/";
        }
        return "redirect:/login?error";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}