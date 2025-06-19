package com.concesionario.comercial.domain.dto;

import com.concesionario.comercial.domain.entities.ServicioMecanico;

import java.time.LocalDate;
import java.util.Date;

public class ServicioMecanicoDTO {
    private Long clienteId;
    private LocalDate fechaEntrega;
    private Integer kilometros;
    private Long vehiculoId;
    private Boolean conGarantia;

    public ServicioMecanicoDTO(ServicioMecanico servicioMecanico) {
        this.clienteId = servicioMecanico.getCliente().getId();
        this.fechaEntrega = servicioMecanico.getFechaEntrega();
        this.kilometros = servicioMecanico.getKilometros();
        this.vehiculoId = servicioMecanico.getVehiculoId();
        this.conGarantia = servicioMecanico.getEnGarantia();
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getKilometros() {
        return kilometros;
    }

    public void setKilometros(Integer kilometros) {
        this.kilometros = kilometros;
    }

    public Long getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Long vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public Boolean getConGarantia() {
        return conGarantia;
    }

    public void setConGarantia(Boolean conGarantia) {
        this.conGarantia = conGarantia;
    }

}
