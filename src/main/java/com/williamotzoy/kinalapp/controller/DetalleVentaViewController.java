package com.williamotzoy.kinalapp.controller;

import com.williamotzoy.kinalapp.entity.DetalleVenta;
import com.williamotzoy.kinalapp.service.IDetalleVentaService;
import com.williamotzoy.kinalapp.service.IProductoService;
import com.williamotzoy.kinalapp.service.IVentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/detalle-ventas")
public class DetalleVentaViewController {

    private final IDetalleVentaService detalleVentaService;
    private final IProductoService productoService;
    private final IVentaService ventaService;

    public DetalleVentaViewController(IDetalleVentaService detalleVentaService, IProductoService productoService, IVentaService ventaService) {
        this.detalleVentaService = detalleVentaService;
        this.productoService = productoService;
        this.ventaService = ventaService;
    }

    @GetMapping
    public String listar(Model model, @RequestParam(required = false) String code) {
        if (code != null && !code.isEmpty()){
            try {
                Long codigo = Long.parseLong(code);
                DetalleVenta detalleVenta = detalleVentaService.buscarPorCodigo(codigo)
                        .orElse(null);
                model.addAttribute("detalleVenta", detalleVenta != null ? List.of(detalleVenta) : List.of());
            } catch (NumberFormatException e){
                model.addAttribute("detalleVenta", List.of());
            }
        } else {
            model.addAttribute("detalleVenta", detalleVentaService.listarTodos());
        }
        return "detalleVenta/detalleVenta-table";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("detalleVenta", new DetalleVenta());
        model.addAttribute("productos", productoService.listarTodos());
        model.addAttribute("ventas", ventaService.listarTodos());
        return "detalleVenta/detalleVenta-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute DetalleVenta detalleVenta) {
        detalleVentaService.guardar(detalleVenta);
        return "redirect:/detalle-ventas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        DetalleVenta detalle = detalleVentaService.buscarPorCodigo(id)
                .orElseThrow(() -> new RuntimeException("Detalle de Venta no encontrado"));

        model.addAttribute("detalleVenta", detalle);
        model.addAttribute("productos", productoService.listarTodos());
        model.addAttribute("ventas", ventaService.listarTodos());

        return "detalleVenta/detalleVenta-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        detalleVentaService.eliminar(id);
        return "redirect:/detalle-ventas";
    }
}