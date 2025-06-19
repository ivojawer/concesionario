package com.concesionario.comercial.presentacion;

import com.concesionario.comercial.domain.dto.AltaClienteDTO;
import com.concesionario.comercial.servicio.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    private final IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    ResponseEntity create(@RequestBody AltaClienteDTO clienteDTO){
        clienteService.crearCliente(clienteDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }


}
