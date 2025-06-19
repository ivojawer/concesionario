package com.concesionario.comercial.servicio;

import com.concesionario.comercial.domain.dto.AltaVentaDTO;
import com.concesionario.comercial.domain.dto.VentaDTO;

import java.util.Collection;

public interface IVentaService {

    void vender(AltaVentaDTO ventaDTO);

    Collection<VentaDTO> findAll();
}
