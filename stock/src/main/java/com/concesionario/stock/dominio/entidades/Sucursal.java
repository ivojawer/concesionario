package com.concesionario.stock.dominio.entidades;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "localidad_unique_constraint", columnNames = {"localidad_id"})})
public class Sucursal {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;

    private String nombre;

    private String direccion;

    private Date fechaApertura;

    private Integer tiempoEntregaLocal;

    private Integer tiempoEntregaCentroDistribucion;

    public Sucursal(Localidad localidad, String nombre, String direccion, Date fechaApertura, Integer tiempoEntregaLocal, Integer tiempoEntregaCentroDistribucion) {
        this.localidad = localidad;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaApertura = fechaApertura;
        this.tiempoEntregaLocal = tiempoEntregaLocal;
        this.tiempoEntregaCentroDistribucion = tiempoEntregaCentroDistribucion;
    }

    public Sucursal() {

    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getTiempoEntregaLocal() {
        return tiempoEntregaLocal;
    }

    public void setTiempoEntregaLocal(Integer tiempoEntregaLocal) {
        this.tiempoEntregaLocal = tiempoEntregaLocal;
    }

    public Integer getTiempoEntregaCentroDistribucion() {
        return tiempoEntregaCentroDistribucion;
    }

    public void setTiempoEntregaCentroDistribucion(Integer tiempoEntregaCentroDistribucion) {
        this.tiempoEntregaCentroDistribucion = tiempoEntregaCentroDistribucion;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
}
