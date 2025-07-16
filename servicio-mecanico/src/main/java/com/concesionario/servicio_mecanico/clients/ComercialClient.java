package com.concesionario.servicio_mecanico.clients;

import com.concesionario.servicio_mecanico.domain.dto.VentaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "comercial")
public interface ComercialClient {
    
    @GetMapping("/ventas/{id}")
    ResponseEntity<VentaDTO> findVentaById(@PathVariable("id") Long ventaId);
}
