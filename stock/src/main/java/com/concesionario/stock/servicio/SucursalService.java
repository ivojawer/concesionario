package com.concesionario.stock.servicio;

import com.concesionario.stock.data.SucursalRepository;
import com.concesionario.stock.dominio.dto.SucursalDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SucursalService {
    private final SucursalRepository sucusalRepository;

    public SucursalService(SucursalRepository sucusalRepository) {
        this.sucusalRepository = sucusalRepository;
    }
    
    public Optional<SucursalDTO> findById(Long id) {
        return sucusalRepository.findById(id).map(SucursalDTO::new);
    }
}
