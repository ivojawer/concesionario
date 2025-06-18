package com.concesionario.catalogo.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Marca {
    @Id
    private Long id;

    private String nombre;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
