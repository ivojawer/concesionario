package com.concesionario.stock.dominio.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Provincia {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @ManyToOne
    private Pais pais;

    public Provincia(Pais pais, String nombre) {
        this.pais = pais;
        this.nombre = nombre;
    }

    public Provincia() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
