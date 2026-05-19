package com.williamotzoy.kinalapp.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalleVenta")
public class DetalleVenta {

    @Id
    @Column(name = "codigo_detalle_venta")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long codigoDetalleVenta;
    @Column(nullable = false)
    private Long cantidad;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;
    @Column(nullable = false)
    private BigDecimal subTotal;

    @JsonIgnoreProperties("productoDetallesVenta")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoProducto", foreignKey = @ForeignKey(name = "FK_producto_detalle_venta"))
    private Producto productoDetalleVenta;

    @JsonIgnoreProperties("ventaDetalles")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoVenta", foreignKey = @ForeignKey(name = "FK_venta_detalle_venta"))
    private Venta ventaDetalle;

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

    public Producto getProductoDetalleVenta(){
        return productoDetalleVenta;
    }
    public void setProductoDetalleVenta(Producto productoDetalleVenta){
        this.productoDetalleVenta = productoDetalleVenta;
    }

    public Venta getVentaDetalle() {
        return ventaDetalle;
    }
    public void setVentaDetalle(Venta ventaDetalle) {
        this.ventaDetalle = ventaDetalle;
    }
}
