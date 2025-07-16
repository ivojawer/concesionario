package com.concesionario.servicio_mecanico.servicio;

import com.concesionario.servicio_mecanico.domain.dto.AltaServicioMecanicoDTO;
import com.concesionario.servicio_mecanico.domain.dto.ServicioMecanicoDTO;

import java.util.Collection;
import java.util.List;

public interface IServicioMecanicoService {
    void crear(AltaServicioMecanicoDTO servicioMecanicoDTO);
    Collection<ServicioMecanicoDTO> listarTodos();
    List<ServicioMecanicoDTO> listarPorCliente(Long clienteId);
}
