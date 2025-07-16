package com.concesionario.comercial.presentacion;

import com.concesionario.comercial.domain.dto.AltaVentaDTO;
import com.concesionario.comercial.domain.dto.VentaDTO;
import com.concesionario.comercial.domain.exceptions.VentaException;
import com.concesionario.comercial.servicio.IVentaService;
import org.springframework.http.HttpStatus;
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
        try {
            ventaService.vender(ventaDTO);
            return ResponseEntity.ok().build();
        } catch (VentaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Collection<VentaDTO>> findAll(){
        return ResponseEntity.ok(ventaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDTO> findById(@PathVariable("id") Long ventaId) {
        try {
            VentaDTO venta = ventaService.findById(ventaId);
            return ResponseEntity.ok(venta);
        } catch (VentaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
