package com.concesionario.comercial.presentacion;

import com.concesionario.comercial.domain.dto.AltaServicioMecanicoDTO;
import com.concesionario.comercial.domain.dto.ServicioMecanicoDTO;
import com.concesionario.comercial.servicio.IServicioMecanicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("servicios-mecanicos")
public class ServicioMecanicoController {
    private final IServicioMecanicoService servicioMecanicoService;

    public ServicioMecanicoController(IServicioMecanicoService servicioMecanicoService) {
        this.servicioMecanicoService = servicioMecanicoService;
    }

    @PostMapping
    ResponseEntity crear(@RequestBody AltaServicioMecanicoDTO servicioMecanicoDTO){
        servicioMecanicoService.crear(servicioMecanicoDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<Collection<ServicioMecanicoDTO>> listarTodos(){
        return ResponseEntity.ok(servicioMecanicoService.listarTodos());
    }
}
