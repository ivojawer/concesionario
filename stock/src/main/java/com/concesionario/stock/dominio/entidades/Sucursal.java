package com.concesionario.stock.dominio.entidades;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "localidad_unique_constraint", columnNames = {"localidad_id"})})
public class Sucursal {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;

    private String nombre;

    private String direccion;

    private Date fechaApertura;

    private int tiempoEntregaLocal;

    private int tiempoEntregaCentroDistribucion;

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
