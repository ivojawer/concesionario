package com.concesionario.comercial.domain.dto;

public class AltaVendedorDTO {
    private String nombre;

    public AltaVendedorDTO() {
    }

    public AltaVendedorDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
