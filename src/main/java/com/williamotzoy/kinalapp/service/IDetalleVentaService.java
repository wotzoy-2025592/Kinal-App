package com.williamotzoy.kinalapp.service;

import com.williamotzoy.kinalapp.entity.DetalleVenta;

import java.util.List;
import java.util.Optional;

public interface IDetalleVentaService {

    List<DetalleVenta> listarTodos();
    List<DetalleVenta> listarActivos();

    DetalleVenta guardar(DetalleVenta detalleVenta);
    Optional<DetalleVenta> buscarPorCodigo(Long codigo);
    DetalleVenta actualizar(Long codigo, DetalleVenta detalleVenta);
    void eliminar(Long codigo);

    boolean existePorCodigo(Long codigo);
}
