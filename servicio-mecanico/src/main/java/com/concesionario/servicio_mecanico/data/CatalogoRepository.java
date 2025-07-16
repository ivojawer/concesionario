package com.concesionario.servicio_mecanico.data;

import com.concesionario.servicio_mecanico.domain.dto.Vehiculo;
import com.concesionario.servicio_mecanico.domain.exceptions.NotFoundException;
import com.concesionario.servicio_mecanico.domain.exceptions.RepositoryException;

public interface CatalogoRepository {
    Vehiculo findVehiculoById(Long vehiculoId) throws NotFoundException, RepositoryException;
}
