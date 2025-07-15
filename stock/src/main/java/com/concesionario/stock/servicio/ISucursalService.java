package com.concesionario.stock.servicio;

import com.concesionario.stock.dominio.dto.SucursalDTO;

import java.util.Optional;

public interface ISucursalService {
    Optional<SucursalDTO> findById(Long id);
}
