package com.williamotzoy.kinalapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ventas")
public class Venta {
    @Id
    @Column(name = "codigo_venta")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long codigoVenta;
    @Column(nullable = false)
    private Date fechaVenta;
    @Column(nullable = false)
    private BigDecimal total;
    @Column(nullable = false)
    private Long estado;

    @JsonIgnoreProperties("clienteVentas")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DPICliente", foreignKey = @ForeignKey(name = "FK_cliente_venta"))
    private Cliente clienteVenta;

    @JsonIgnoreProperties("usuarioVentas")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoUsuario", foreignKey = @ForeignKey(name = "FK_usuario_venta"))
    private Usuario usuarioVenta;

    @OneToMany(mappedBy = "ventaDetalle", cascade = CascadeType.ALL)
    private List<DetalleVenta> ventaDetalles;

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
