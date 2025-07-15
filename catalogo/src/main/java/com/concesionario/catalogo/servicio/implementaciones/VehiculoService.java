package com.concesionario.catalogo.servicio.implementaciones;

import com.concesionario.catalogo.data.IMarcaRepository;
import com.concesionario.catalogo.data.IVehiculoRepository;
import com.concesionario.catalogo.domain.dto.AltaVehiculoDTO;
import com.concesionario.catalogo.domain.dto.VehiculoDTO;
import com.concesionario.catalogo.domain.entities.Marca;
import com.concesionario.catalogo.domain.entities.Vehiculo;
import com.concesionario.catalogo.servicio.IVehiculoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService {
    private final IVehiculoRepository vehiculoRepository;
    private final IMarcaRepository marcaRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository, IMarcaRepository marcaRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.marcaRepository = marcaRepository;
    }


    @Override
    public void agregarVehiculo(AltaVehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = new Vehiculo();
        Marca marca = marcaRepository.findById(vehiculoDTO.getMarcaId()).orElseThrow();
        vehiculo.setMarca(marca);
        vehiculo.setModelo(vehiculoDTO.getModelo());
        vehiculo.setSubtotal(vehiculoDTO.getSubtotal());
        vehiculo.setAniosGarantia(vehiculoDTO.getAniosGarantia());

        vehiculoRepository.save(vehiculo);
    }

    @Override
    public Optional<VehiculoDTO> findById(Long id) {
        return vehiculoRepository.findById(id).map(VehiculoDTO::fromVehiculo);
    }

    @Override
    public List<VehiculoDTO> findAll() {
        return vehiculoRepository.findAll().stream().map(VehiculoDTO::fromVehiculo).collect(Collectors.toList());
    }

    @Override
    public List<VehiculoDTO> findAll(Long marcaId) {
        Marca marca = marcaRepository.findById(marcaId).orElseThrow();
        return vehiculoRepository.findAllByMarca(marca).stream().map(VehiculoDTO::fromVehiculo).collect(Collectors.toList());
    }


}
