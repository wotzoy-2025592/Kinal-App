package com.williamotzoy.kinalapp.repository;

import com.williamotzoy.kinalapp.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByEstado (Long estado);
}
