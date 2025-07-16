package com.concesionario.comercial.clients;

import com.concesionario.comercial.domain.dto.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "clientes")
public interface ClienteClient {
    @GetMapping("/clientes/{id}")
    ResponseEntity<ClienteDTO> findById(@PathVariable("id") Long clienteId);
}
