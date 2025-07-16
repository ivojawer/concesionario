package com.concesionario.servicio_mecanico.data;

import com.concesionario.servicio_mecanico.domain.dto.VentaDTO;
import com.concesionario.servicio_mecanico.domain.exceptions.NotFoundException;
import com.concesionario.servicio_mecanico.domain.exceptions.RepositoryException;

public interface ComercialRepository {
    VentaDTO findVentaById(Long ventaId) throws NotFoundException, RepositoryException;
}
