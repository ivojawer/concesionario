package com.concesionario.catalogo.servicio;

import com.concesionario.catalogo.domain.dto.AltaVehiculoDTO;
import com.concesionario.catalogo.domain.dto.VehiculoDTO;
import com.concesionario.catalogo.domain.entities.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    void agregarVehiculo(AltaVehiculoDTO vehiculo);
    VehiculoDTO findById(Long id);
    List<VehiculoDTO> findAll();
    List<VehiculoDTO> findAll(Long marcaId);
}
