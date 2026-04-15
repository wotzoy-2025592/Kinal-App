package com.williamotzoy.kinalapp.service;


import com.williamotzoy.kinalapp.entity.Venta;
import com.williamotzoy.kinalapp.repository.VentaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VentaService implements IVentaService{

    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> listarTodos() {
        return ventaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> listarActivos() {
        return ventaRepository.findByEstado(1L);
    }

    @Override
    public Venta guardar(Venta venta) {
        validarVenta(venta);
        //if (venta.getEstado() == 0) {
            //venta.setEstado(1L);
        //}
        return ventaRepository.save(venta);
    }

    @Override
    public Optional<Venta> buscarPorCodigo(Long codigo) {
        return ventaRepository.findById(codigo);
    }

    @Override
    public Venta actualizar(Long codigo, Venta venta) {
        if(!ventaRepository.existsById(codigo)) {
            throw new RuntimeException("La venta no se encontró con el código: " + codigo);
        }
        venta.setCodigoVenta(codigo);
        validarVenta(venta);
        return ventaRepository.save(venta);
    }

    @Override
    public void eliminar(Long codigo){
        if (!ventaRepository.existsById(codigo)) {
            throw new RuntimeException("La venta no se encontró con el código: " + codigo);
        }
        ventaRepository.deleteById(codigo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existePorCodigo(Long codigo) {
        return ventaRepository.existsById(codigo);
    }

    private void validarVenta(Venta venta) {

        if (venta.getFechaVenta() == null) {
            throw new IllegalArgumentException("El campo de fecha es obligatorio");
        }
        if (venta.getTotal() == null) {
            throw new IllegalArgumentException("El campo de total de la venta es obligatorio");
        }
    }

}
