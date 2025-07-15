package com.concesionario.catalogo.servicio.implementaciones;

import com.concesionario.catalogo.data.IMarcaRepository;
import com.concesionario.catalogo.domain.dto.AltaMarcaDTO;
import com.concesionario.catalogo.domain.entities.Marca;
import com.concesionario.catalogo.servicio.IMarcaService;
import org.springframework.stereotype.Service;

@Service
public class MarcaService implements IMarcaService {
    private final IMarcaRepository marcaRepository;

    public MarcaService(IMarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Override
    public void agregarMarca(AltaMarcaDTO marcaDTO) {
        Marca marca = new Marca();
        marca.setNombre(marcaDTO.getNombre());
        marcaRepository.save(marca);
    }
}
