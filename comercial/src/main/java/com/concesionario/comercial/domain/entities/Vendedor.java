package com.concesionario.comercial.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vendedor {
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
