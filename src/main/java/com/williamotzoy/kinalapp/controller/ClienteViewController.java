package com.williamotzoy.kinalapp.controller;

import com.williamotzoy.kinalapp.entity.Cliente;
import com.williamotzoy.kinalapp.service.IClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteViewController {

    private final IClienteService clienteService;

    public ClienteViewController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) String q, Model model){
        if (q != null && !q.isEmpty()) {
            Long codigo = Long.parseLong(q);
            Cliente cliente = clienteService.buscarPorDPI(q).orElse(null);
            if (cliente != null) {
                model.addAttribute("clientes", List.of(cliente));
            } else {
                model.addAttribute("clientes", List.of());
            }
        } else {
            model.addAttribute("clientes", clienteService.listarTodos());
        }
        model.addAttribute("rolActual", "ADMIN");
        return "clientes/cliente-table";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("cliente", new Cliente());
        return "clientes/cliente-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cliente cliente){
        clienteService.guardar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model){
        model.addAttribute("cliente", clienteService.buscarPorDPI(id));
        return "clientes/cliente-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id){
        clienteService.eliminar(id);
        return "redirect:/clientes";
    }
}