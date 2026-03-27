package com.williamotzoy.kinalapp.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalleVenta")
public class DetalleVenta {

    @Id
    @Column(name = "codigo_detalle_venta")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long codigoDetalleVenta;
    @Column
    private Long cantidad;
    @Column
    private BigDecimal precioUnitario;
    @Column
    private BigDecimal subTotal;

    public DetalleVenta(){

    }

    public DetalleVenta(Long codigoDetalleVenta, Long cantidad, BigDecimal precioUnitario, BigDecimal subTotal) {
        this.codigoDetalleVenta = codigoDetalleVenta;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
    }

    public Long getCodigoDetalleVenta() {
        return codigoDetalleVenta;
    }

    public void setCodigoDetalleVenta(Long codigoDetalleVenta) {
        this.codigoDetalleVenta = codigoDetalleVenta;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
}
