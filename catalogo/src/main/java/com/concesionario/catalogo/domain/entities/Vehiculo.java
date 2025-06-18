package com.concesionario.catalogo.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Vehiculo {
    @Id
    private Long id;

    @ManyToOne()
    private Marca marca;

    private String modelo;

    private Integer aniosGarantia;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAniosGarantia() {
        return aniosGarantia;
    }

    public void setAniosGarantia(Integer aniosGarantia) {
        this.aniosGarantia = aniosGarantia;
    }
}
