package com.concesionario.comercial.domain.dto;

public class AjusteDTO {
    public AjusteDTO(Long sucursalId, Long vehiculoId, Integer ajusteCantidad) {
        this.sucursalId = sucursalId;
        this.vehiculoId = vehiculoId;
        this.ajusteCantidad = ajusteCantidad;
    }

    private Long sucursalId;
    private Long vehiculoId;
    private Integer ajusteCantidad;

    public Integer getAjusteCantidad() {
        return ajusteCantidad;
    }

    public void setAjusteCantidad(Integer ajusteCantidad) {
        this.ajusteCantidad = ajusteCantidad;
    }

    public Long getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Long vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public Long getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Long sucursalId) {
        this.sucursalId = sucursalId;
    }
}
