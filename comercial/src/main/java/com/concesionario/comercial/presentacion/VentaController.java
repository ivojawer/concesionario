package com.concesionario.comercial.presentacion;

import com.concesionario.comercial.domain.dto.AltaVentaDTO;
import com.concesionario.comercial.domain.dto.VentaDTO;
import com.concesionario.comercial.servicio.IVentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("ventas")

public class VentaController {
    private final IVentaService ventaService;

    public VentaController(IVentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    public ResponseEntity<Object> createVenta(@RequestBody AltaVentaDTO ventaDTO) {
        ventaService.vender(ventaDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<VentaDTO>> findAll(){
        return ResponseEntity.ok(ventaService.findAll());
    }
}
