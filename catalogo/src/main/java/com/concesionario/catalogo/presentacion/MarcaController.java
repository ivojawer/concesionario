package com.concesionario.catalogo.presentacion;

import com.concesionario.catalogo.domain.dto.AltaMarcaDTO;
import com.concesionario.catalogo.servicio.IMarcaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("marcas")
public class MarcaController {
    private final IMarcaService marcaService;

    public MarcaController(IMarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @PostMapping
    private ResponseEntity<Object> crearMarca(@RequestBody AltaMarcaDTO altaMarcaDTO) {
        marcaService.agregarMarca(altaMarcaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
