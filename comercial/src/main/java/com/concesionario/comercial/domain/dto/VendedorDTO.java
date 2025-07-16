package com.concesionario.comercial.domain.dto;

import com.concesionario.comercial.domain.entities.Vendedor;

public class VendedorDTO {
    private Long id;
    private String nombre;

    public VendedorDTO() {
    }

    public VendedorDTO(Vendedor vendedor) {
        this.id = vendedor.getId();
        this.nombre = vendedor.getNombre();
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
}
