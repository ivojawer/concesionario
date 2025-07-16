package com.concesionario.clientes.presentacion;

import com.concesionario.clientes.domain.dto.AltaClienteDTO;
import com.concesionario.clientes.domain.dto.ClienteDTO;
import com.concesionario.clientes.servicio.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    ResponseEntity findById(@PathVariable Long id){
        Optional<ClienteDTO> cliente = clienteService.findById(id);
        if(cliente.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.of(cliente);
    }

    @GetMapping
    ResponseEntity<List<ClienteDTO>> findAll(){
        List<ClienteDTO> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }
}
