package com.concesionario.catalogo.data;

import com.concesionario.catalogo.domain.entities.Vehiculo;

import java.util.List;

public interface VehiculoRepository {
    Vehiculo findById(Long id);
    List<Vehiculo> findAllByMarca(String marca);
    void save(Vehiculo vehiculo);
}
