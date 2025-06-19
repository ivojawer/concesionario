package com.concesionario.stock.dominio.dto;

import com.concesionario.stock.dominio.entidades.Sucursal;

public class SucursalDTO {

    private Long sucursalId;
    private Integer diasEntregaLocal;
    private Integer diasEntregaCentral;

    public SucursalDTO(Sucursal sucursal) {
        this.sucursalId = sucursal.getId();
        this.diasEntregaCentral = sucursal.getTiempoEntregaLocal();
        this.diasEntregaCentral = sucursal.getTiempoEntregaCentroDistribucion();
    }

    public Integer getDiasEntregaCentral() {
        return diasEntregaCentral;
    }

    public void setDiasEntregaCentral(Integer diasEntregaCentral) {
        this.diasEntregaCentral = diasEntregaCentral;
    }

    public Integer getDiasEntregaLocal() {
        return diasEntregaLocal;
    }

    public void setDiasEntregaLocal(Integer diasEntregaLocal) {
        this.diasEntregaLocal = diasEntregaLocal;
    }

    public Long getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Long sucursalId) {
        this.sucursalId = sucursalId;
    }


}
