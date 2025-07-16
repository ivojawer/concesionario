package com.concesionario.comercial.presentacion;

import com.concesionario.comercial.domain.dto.AltaVendedorDTO;
import com.concesionario.comercial.servicio.IVendedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vendedores")
public class VendedorController {
    private final IVendedorService vendedorService;

    public VendedorController(IVendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @PostMapping
    ResponseEntity<Object> crear(@RequestBody AltaVendedorDTO vendedorDTO){
        vendedorService.create(vendedorDTO);
        return ResponseEntity.ok().build();
    }
}
