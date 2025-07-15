package com.concesionario.stock.presentacion;

import com.concesionario.stock.dominio.dto.SucursalDTO;
import com.concesionario.stock.servicio.ISucursalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sucursales")
public class SucursalController {
    private final ISucursalService sucursalService;

    public SucursalController(ISucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping("{id}")
    ResponseEntity<SucursalDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.of(sucursalService.findById(id));
    }
}
