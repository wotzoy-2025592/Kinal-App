package com.williamotzoy.kinalapp.controller;


import com.williamotzoy.kinalapp.entity.Usuario;
import com.williamotzoy.kinalapp.service.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioViewController {

    private final IUsuarioService usuarioService;

    public UsuarioViewController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) String q, Model model){
        if (q != null && !q.isEmpty()) {
            try {
                Long codigo = Long.parseLong(q);
                Usuario usuario = usuarioService.buscarPorCodigo(codigo).orElse(null);
                if (usuario != null) {
                    model.addAttribute("usuarios", List.of(usuario));
                } else {
                    model.addAttribute("usuarios", List.of());
                }
            } catch (NumberFormatException e) {
                model.addAttribute("usuarios", List.of());
            }
        } else {
            model.addAttribute("usuarios", usuarioService.listarTodos());
        }
        return "usuarios/usuario-table";
    }

    @GetMapping("/nuevo")
    public String nuevoForm(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuarios/usuario-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Usuario usuario) {
        usuarioService.guardar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminar(@PathVariable Long codigo) {
        usuarioService.eliminar(codigo);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{codigo}")
    public String editar(@PathVariable Long codigo, Model model) {
        Usuario usuario = usuarioService.buscarPorCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        model.addAttribute("usuario", usuario);
        return "usuarios/usuario-form";
    }

}
