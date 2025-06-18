package com.concesionario.catalogo.presentacion;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vehiculo")
class VehiculoController {
    @RequestMapping("")
    public String findAll() {
        return "ToDo";
    }

    @RequestMapping("{id}")
    public String findById(@PathVariable Long id) {
        return "ToDo";
    }
}