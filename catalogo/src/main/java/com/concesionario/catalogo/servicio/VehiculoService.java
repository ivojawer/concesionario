package com.concesionario.catalogo.servicio;

import com.concesionario.catalogo.data.IMarcaRepository;
import com.concesionario.catalogo.data.IVehiculoRepository;
import com.concesionario.catalogo.domain.dto.AltaVehiculoDTO;
import com.concesionario.catalogo.domain.dto.VehiculoDTO;
import com.concesionario.catalogo.domain.entities.Marca;
import com.concesionario.catalogo.domain.entities.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.List;
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
        vehiculo.setAniosGarantia(vehiculoDTO.getAniosGarantia());
        Marca marca = marcaRepository.findById(vehiculoDTO.getMarcaId()).orElseThrow();
        vehiculo.setMarca(marca);
        vehiculo.setModelo(vehiculoDTO.getModelo());

        vehiculoRepository.save(vehiculo);
    }

    @Override
    public VehiculoDTO findById(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id).orElseThrow();
        return VehiculoDTO.fromVehiculo(vehiculo);
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
