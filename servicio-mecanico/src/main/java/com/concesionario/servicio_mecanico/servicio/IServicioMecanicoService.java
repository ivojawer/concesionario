package com.concesionario.servicio_mecanico.servicio;

import com.concesionario.servicio_mecanico.domain.dto.AltaServicioMecanicoDTO;
import com.concesionario.servicio_mecanico.domain.dto.ServicioMecanicoDTO;
import com.concesionario.servicio_mecanico.domain.exceptions.ServiceLayerException;

import java.util.Collection;
import java.util.List;

public interface IServicioMecanicoService {
    void crear(AltaServicioMecanicoDTO servicioMecanicoDTO) throws ServiceLayerException;
    Collection<ServicioMecanicoDTO> listarTodos();
    List<ServicioMecanicoDTO> listarPorCliente(Long clienteId);
}
