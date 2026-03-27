package com.williamotzoy.kinalapp.service;

import com.williamotzoy.kinalapp.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    List<Producto> listarTodos();
    List<Producto> listarActivos();

    Producto guardar(Producto producto);
    Optional<Producto> buscarPorCodigo(Long codigo);
    Producto actualizar(Long codigo, Producto producto);
    void eliminar(Long codigo);

    boolean existePorCodigo(Long codigo);
}
