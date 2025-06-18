package com.concesionario.comercial.presentacion;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class VentaController {
    @PostMapping("/")
    public String createVenta() {
        return "ToDo";
    }
}
