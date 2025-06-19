package com.concesionario.stock.dominio.dto;

import com.concesionario.stock.dominio.entidades.Stock;

public class StockDTO {
    private Long vehiculoId;
    private Integer cantidad;
    private Long sucursalId;

    public StockDTO(Stock stock) {
        this.vehiculoId = stock.getVehiculoId();
        this.cantidad = stock.getCantidad();
        this.sucursalId = stock.getSucursal().getId();
    }

    public Long getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Long vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Long sucursalId) {
        this.sucursalId = sucursalId;
    }
}
