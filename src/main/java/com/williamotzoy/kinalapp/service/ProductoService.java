package com.williamotzoy.kinalapp.service;

import com.williamotzoy.kinalapp.entity.Producto;
import com.williamotzoy.kinalapp.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService implements IProductoService{

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarActivos() {
        return productoRepository.findByEstado(1L);
    }

    @Override
    public Producto guardar(Producto producto) {
        validarProducto(producto);
        if (producto.getEstado() == 0)
            producto.setEstado(1L);
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> buscarPorCodigo(Long codigo){
        return productoRepository.findById(codigo);
    }

    @Override
    public Producto actualizar(Long codigo, Producto producto){
        if (!productoRepository.existsById(codigo)){
            throw new RuntimeException("El producto no se encontro con el código: " + codigo);
        }
        producto.setCodigoProducto(codigo);
        validarProducto(producto);
        return productoRepository.save(producto);
    }

    @Override
    public void eliminar(Long codigo){
        if(!productoRepository.existsById(codigo)){
            throw new RuntimeException("El producto no fue encontrado con el código: " + codigo);
        }
        productoRepository.deleteById(codigo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existePorCodigo(Long codigo){
        return productoRepository.existsById(codigo);
    }

    private void validarProducto(Producto producto){

        if (producto.getNombreProducto() == null || producto.getNombreProducto().trim().isEmpty()){
            throw new IllegalArgumentException("El campo de nombre de producto es obligatorio.");
        }
        if (producto.getPrecio() == null) {
            throw new IllegalArgumentException("El campo de precio es obligatorio");
        }
        if (producto.getStock() == null) {
            throw new IllegalArgumentException("El campo de stock es obligatorio");
        }
    }

}
