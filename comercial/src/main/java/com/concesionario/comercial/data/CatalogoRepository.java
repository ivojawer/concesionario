package com.concesionario.comercial.data;

import com.concesionario.comercial.domain.entities.Vehiculo;

public interface CatalogoRepository {
    Vehiculo findVehiculoById(Long vehiculoId);
}
