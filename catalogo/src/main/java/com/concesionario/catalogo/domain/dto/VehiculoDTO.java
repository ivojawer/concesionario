package com.concesionario.catalogo.domain.dto;

import com.concesionario.catalogo.domain.entities.Vehiculo;

public class VehiculoDTO {
    private Long id;
    private String marca;
    private String modelo;
    private Integer aniosGarantia;
    private Float subtotal;

    public static VehiculoDTO fromVehiculo(Vehiculo vehiculo) {
        VehiculoDTO dto = new VehiculoDTO();
        dto.setId(vehiculo.getId());
        dto.setAniosGarantia(vehiculo.getAniosGarantia());
        dto.setModelo(vehiculo.getModelo());
        dto.setMarca(vehiculo.getMarca().getNombre());
        dto.setSubtotal(vehiculo.getSubtotal());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAniosGarantia() {
        return aniosGarantia;
    }

    public void setAniosGarantia(Integer aniosGarantia) {
        this.aniosGarantia = aniosGarantia;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }
}
