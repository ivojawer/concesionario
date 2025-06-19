package com.concesionario.comercial.presentacion;

import com.concesionario.comercial.domain.dto.AltaVentaDTO;
import com.concesionario.comercial.servicio.IVentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class VentaController {
    private final IVentaService ventaService;

    public VentaController(IVentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> createVenta(@RequestBody AltaVentaDTO ventaDTO) {
        ventaService.vender(ventaDTO);
        return ResponseEntity.ok().build();
    }
}
