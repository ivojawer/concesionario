package com.concesionario.comercial.domain.entities;

public class Sucursal {
    private Long sucursalId;
    private Integer diasEntregaLocal;
    private Integer diasEntregaCentral;

    public Long getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Long sucursalId) {
        this.sucursalId = sucursalId;
    }

    public Integer getDiasEntregaLocal() {
        return diasEntregaLocal;
    }

    public void setDiasEntregaLocal(Integer diasEntregaLocal) {
        this.diasEntregaLocal = diasEntregaLocal;
    }

    public Integer getDiasEntregaCentral() {
        return diasEntregaCentral;
    }

    public void setDiasEntregaCentral(Integer diasEntregaCentral) {
        this.diasEntregaCentral = diasEntregaCentral;
    }
}
