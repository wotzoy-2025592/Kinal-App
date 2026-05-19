package com.williamotzoy.kinalapp.repository;

import com.williamotzoy.kinalapp.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByEstado (Long estado);
}
