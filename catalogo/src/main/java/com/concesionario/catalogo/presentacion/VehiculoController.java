package com.concesionario.catalogo.presentacion;

import com.concesionario.catalogo.domain.dto.AltaVehiculoDTO;
import com.concesionario.catalogo.domain.dto.VehiculoDTO;
import com.concesionario.catalogo.servicio.IVehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("vehiculos")
class VehiculoController {
    private final IVehiculoService vehiculoService;

    VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("")
    public ResponseEntity<Collection<VehiculoDTO>> findAll() {
        return new ResponseEntity<>(vehiculoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<VehiculoDTO> findById(@PathVariable Long id) {
        VehiculoDTO vehiculoDTO = vehiculoService.findById(id);
        return new ResponseEntity<>(vehiculoDTO, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity create(@RequestBody AltaVehiculoDTO vehiculo) {
        vehiculoService.agregarVehiculo(vehiculo);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}