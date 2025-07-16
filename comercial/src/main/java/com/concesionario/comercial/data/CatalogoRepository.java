package com.concesionario.comercial.data;

import com.concesionario.comercial.domain.entities.Vehiculo;
import com.concesionario.comercial.domain.exceptions.NotFoundException;
import com.concesionario.comercial.domain.exceptions.RepositoryException;

public interface CatalogoRepository {
    Vehiculo findVehiculoById(Long vehiculoId) throws NotFoundException, RepositoryException;
}
