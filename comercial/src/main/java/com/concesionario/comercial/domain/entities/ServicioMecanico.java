package com.concesionario.comercial.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class ServicioMecanico {
    @Id
    private Long id;

    private Boolean enGarantia;

    private int kilometros;

    private Date fechaEntrega;

    @ManyToOne
    private Cliente cliente;

    private Integer vehiculoId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
