package com.concesionario.comercial.domain.entities;

public class Vehiculo {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAniosGarantia() {
        return aniosGarantia;
    }

    public void setAniosGarantia(Integer aniosGarantia) {
        this.aniosGarantia = aniosGarantia;
    }

    public Long getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Long subtotal) {
        this.subtotal = subtotal;
    }

    private Long id;
    private Integer aniosGarantia;
    private Long subtotal;
}
