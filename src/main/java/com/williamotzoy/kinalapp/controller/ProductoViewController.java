package com.williamotzoy.kinalapp.controller;

import com.williamotzoy.kinalapp.entity.Producto;
import com.williamotzoy.kinalapp.service.IProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoViewController {

    private IProductoService productoService;

    public ProductoViewController(IProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) String q, Model model){
        if (q != null && !q.isEmpty()) {
            try {
                Long codigo = Long.parseLong(q);
                Producto producto = productoService.buscarPorCodigo(codigo).orElse(null);
                if (producto != null) {
                    model.addAttribute("productos", List.of(producto));
                } else {
                    model.addAttribute("productos", List.of());
                }
            } catch (NumberFormatException e) {
                model.addAttribute("productos", List.of());
            }
        } else {
            model.addAttribute("productos", productoService.listarTodos());
        }
        model.addAttribute("rolActual", "ADMIN");
        return "productos/producto-table";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("producto", new Producto());
        return "productos/producto-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto){
        productoService.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model){
        model.addAttribute("producto", productoService.buscarPorCodigo(id));
        return "productos/producto-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        productoService.eliminar(id);
        return "redirect:/productos";
    }
}
