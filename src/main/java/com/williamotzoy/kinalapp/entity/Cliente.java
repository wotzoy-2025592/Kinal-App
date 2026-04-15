package com.williamotzoy.kinalapp.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @Column (name = "dpi_cliente")
    private String DPICliente;
    @Column(nullable = false)
    private String nombreCliente;
    @Column(nullable = false)
    private String apellidoCliente;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private Long estado;

    @OneToMany(mappedBy = "clienteVenta", cascade = CascadeType.ALL)
    private List<Venta> clienteVentas;

    public Cliente() {
    }

    public Cliente(String nombreCliente, String apellidoCliente, String direccion, Long estado, String DPICliente) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.direccion = direccion;
        this.estado = estado;
        this.DPICliente = DPICliente;
    }

    public String getDPICliente() {
        return DPICliente;
    }

    public void setDPICliente(String DPICliente) {
        this.DPICliente = DPICliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }
}
