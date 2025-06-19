package com.concesionario.comercial.servicio;

import com.concesionario.comercial.domain.dto.AltaServicioMecanicoDTO;
import com.concesionario.comercial.domain.dto.ServicioMecanicoDTO;

import java.util.Collection;

public interface IServicioMecanicoService {
    void crear(AltaServicioMecanicoDTO servicioMecanicoDTO);

    Collection<ServicioMecanicoDTO> listarTodos();
}
