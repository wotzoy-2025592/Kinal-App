package com.williamotzoy.kinalapp.service;

import com.williamotzoy.kinalapp.entity.DetalleVenta;
import com.williamotzoy.kinalapp.repository.DetalleVentaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DetalleVentaService implements IDetalleVentaService{

    private final DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaService(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetalleVenta> listarTodos() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta guardar(DetalleVenta detalleVenta) {
        validarDetalleVenta(detalleVenta);
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public Optional<DetalleVenta> buscarPorCodigo(Long codigo) {
        return detalleVentaRepository.findById(codigo);
    }

    @Override
    public DetalleVenta actualizar(Long codigo, DetalleVenta detalleVenta) {
        if (!detalleVentaRepository.existsById(codigo)) {
            throw new RuntimeException("El detalle de venta no se pudo encontrar: " + codigo);
        }
        detalleVenta.setCodigoDetalleVenta(codigo);
        validarDetalleVenta(detalleVenta);
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public void eliminar(Long codigo) {
        if (!detalleVentaRepository.existsById(codigo)){
            throw new RuntimeException("El detalle de venta nose pudo encontrar: " + codigo);
        }
        detalleVentaRepository.deleteById(codigo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existePorCodigo(Long codigo){
        return detalleVentaRepository.existsById(codigo);
    }

    private void validarDetalleVenta(DetalleVenta detalleVenta) {

        if (detalleVenta.getCantidad() == null) {
            throw new IllegalArgumentException("El campo de cantidad es obligatorio");
        }
        if (detalleVenta.getPrecioUnitario() == null) {
            throw new IllegalArgumentException("El precio es un campo obligatorio");
        }
        if (detalleVenta.getSubTotal() == null) {
            throw new IllegalArgumentException("El campo de subtotal es un campo obligatorio");
        }
    }

}