package com.concesionario.servicio_mecanico.presentacion;

import com.concesionario.servicio_mecanico.domain.dto.AltaServicioMecanicoDTO;
import com.concesionario.servicio_mecanico.domain.dto.ServicioMecanicoDTO;
import com.concesionario.servicio_mecanico.servicio.IServicioMecanicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("servicios-mecanicos")
public class ServicioMecanicoController {
    private final IServicioMecanicoService servicioMecanicoService;

    public ServicioMecanicoController(IServicioMecanicoService servicioMecanicoService) {
        this.servicioMecanicoService = servicioMecanicoService;
    }

    @PostMapping
    ResponseEntity crear(@RequestBody AltaServicioMecanicoDTO servicioMecanicoDTO) {
        servicioMecanicoService.crear(servicioMecanicoDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<Collection<ServicioMecanicoDTO>> listarTodos() {
        return ResponseEntity.ok(servicioMecanicoService.listarTodos());
    }

    @GetMapping("/cliente/{clienteId}")
    ResponseEntity<List<ServicioMecanicoDTO>> listarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(servicioMecanicoService.listarPorCliente(clienteId));
    }
}
