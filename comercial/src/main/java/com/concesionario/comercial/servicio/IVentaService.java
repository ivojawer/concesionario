package com.concesionario.comercial.servicio;

import com.concesionario.comercial.domain.dto.AltaVentaDTO;
import com.concesionario.comercial.domain.dto.VentaDTO;
import com.concesionario.comercial.domain.exceptions.VentaException;

import java.util.Collection;

public interface IVentaService {

    void vender(AltaVentaDTO ventaDTO) throws VentaException;

    Collection<VentaDTO> findAll();
    
    VentaDTO findById(Long ventaId) throws VentaException;
}
