package com.concesionario.stock.servicio.implementaciones;

import com.concesionario.stock.data.SucursalRepository;
import com.concesionario.stock.dominio.dto.SucursalDTO;
import com.concesionario.stock.servicio.ISucursalService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SucursalService implements ISucursalService {
    private final SucursalRepository sucusalRepository;

    public SucursalService(SucursalRepository sucusalRepository) {
        this.sucusalRepository = sucusalRepository;
    }
    
    public Optional<SucursalDTO> findById(Long id) {
        return sucusalRepository.findById(id).map(SucursalDTO::new);
    }
}
