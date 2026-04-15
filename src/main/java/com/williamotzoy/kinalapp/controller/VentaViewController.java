package com.williamotzoy.kinalapp.controller;

import com.williamotzoy.kinalapp.entity.Venta;
import com.williamotzoy.kinalapp.service.IVentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ventas")
public class VentaViewController {

    private final IVentaService ventaService;

    public VentaViewController(IVentaService ventaService) {
        this.ventaService = ventaService;
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
        model.addAttribute("rolActual", "ADMIN");
        return "ventas/venta-table";
    }

    @GetMapping("/nuevo")
    public String nuevoForm(Model model) {
        model.addAttribute("venta", new Venta());
        // Nota: Los objetos para los selectores (clientes/usuarios)
        // no se cargan aquí por restricción del usuario.
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
        return "ventas/venta-form";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminar(@PathVariable Long codigo) {
        ventaService.eliminar(codigo);
        return "redirect:/ventas";
    }
}