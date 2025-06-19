package com.concesionario.catalogo.domain.dto;

public class AltaVehiculoDTO {
    private Long marcaId;
    private String modelo;
    private Integer aniosGarantia;
    private Float subtotal;

    public Long getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Long marcaId) {
        this.marcaId = marcaId;
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
