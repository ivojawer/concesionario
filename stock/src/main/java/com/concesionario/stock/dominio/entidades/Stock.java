package com.concesionario.stock.dominio.entidades;

import jakarta.persistence.*;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long vehiculoId;

    @ManyToOne()
    private Sucursal sucursal;

    private Integer cantidad;

    public Stock(Long vehiculoId, Sucursal sucursal, Integer cantidad) {
        this.vehiculoId = vehiculoId;
        this.sucursal = sucursal;
        this.cantidad = cantidad;
    }

    public Stock() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Long vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void ajustarCantidad(Integer cantidad) {
        this.cantidad += cantidad;
    }
}
