package com.concesionario.catalogo.servicio;

import com.concesionario.catalogo.domain.dto.AltaVehiculoDTO;
import com.concesionario.catalogo.domain.dto.VehiculoDTO;

import java.util.List;
import java.util.Optional;

public interface IVehiculoService {
    void agregarVehiculo(AltaVehiculoDTO vehiculo);
    Optional<VehiculoDTO> findById(Long id);
    List<VehiculoDTO> findAll();
    List<VehiculoDTO> findAll(Long marcaId);
}
