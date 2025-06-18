package com.concesionario.stock.dominio.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Localidad {
    @Id
    @GeneratedValue
    private Integer id;

    private String nombre;
}
