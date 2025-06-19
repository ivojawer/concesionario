package com.concesionario.comercial.domain.dto;

import com.concesionario.comercial.domain.entities.Venta;

public class VentaDTO {
    private Long vendedorId;
    private Long vehiculoId;
    private Float monto;
    private Long clienteId;


    public VentaDTO(Venta venta) {
        this.vendedorId = venta.getVendedor().getId();
        this.vehiculoId = venta.getVehiculoId();
        this.monto = venta.getTotal();
        this.clienteId = venta.getCliente().getId();
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Long getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Long vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public Long getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }

}
