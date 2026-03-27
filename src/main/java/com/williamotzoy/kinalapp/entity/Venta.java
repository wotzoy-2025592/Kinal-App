package com.williamotzoy.kinalapp.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ventas")
public class Venta {
    @Id
    @Column(name = "codigo_venta")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long codigoVenta;
    @Column
    private Date fechaVenta;
    @Column
    private BigDecimal total;
    @Column
    private Long estado;

    public Venta(){
    }

    public Venta(Long codigoVenta, Date fechaVenta, BigDecimal total, Long estado) {
        this.codigoVenta = codigoVenta;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.estado = estado;
    }

    public Long getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Long codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }
    
}
