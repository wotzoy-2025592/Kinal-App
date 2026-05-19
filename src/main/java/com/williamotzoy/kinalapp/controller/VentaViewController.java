package com.williamotzoy.kinalapp.controller;

import com.williamotzoy.kinalapp.entity.Venta;
import com.williamotzoy.kinalapp.service.IClienteService;
import com.williamotzoy.kinalapp.service.IUsuarioService;
import com.williamotzoy.kinalapp.service.IVentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ventas")
public class VentaViewController {

    private final IVentaService ventaService;
    private final IClienteService clienteService;
    private final IUsuarioService usuarioService;

    public VentaViewController(IVentaService ventaService, IClienteService clienteService, IUsuarioService usuarioService) {
        this.ventaService = ventaService;
        this.clienteService = clienteService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) String q, Model model) {
        if (q != null && !q.isEmpty()) {
            try {
                Long codigo = Long.parseLong(q);
                Venta venta = ventaService.buscarPorCodigo(codigo).orElse(null);
                model.addAttribute("ventas", venta != null ? List.of(venta) : List.of());
            } catch (NumberFormatException e) {
                model.addAttribute("ventas", List.of());
            }
        } else {
            model.addAttribute("ventas", ventaService.listarTodos());
        }
        return "ventas/venta-table";
    }

    @GetMapping("/nuevo")
    public String nuevoForm(Model model) {
        model.addAttribute("venta", new Venta());
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "ventas/venta-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Venta venta) {
        ventaService.guardar(venta);
        return "redirect:/ventas";
    }

    @GetMapping("/editar/{codigo}")
    public String editar(@PathVariable Long codigo, Model model) {
        Venta venta = ventaService.buscarPorCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        model.addAttribute("venta", venta);
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "ventas/venta-form";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminar(@PathVariable Long codigo) {
        ventaService.eliminar(codigo);
        return "redirect:/ventas";
    }
}