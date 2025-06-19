package com.concesionario.stock.dominio.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pais {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    public Pais(String nombre) {
        this.nombre = nombre;
    }

    public Pais() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
