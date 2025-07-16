package com.concesionario.comercial.clients;

import com.concesionario.comercial.domain.dto.AjusteDTO;
import com.concesionario.comercial.domain.entities.Stock;
import com.concesionario.comercial.domain.entities.Sucursal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "stock")
public interface StockClient {
    @GetMapping("/stock")
    ResponseEntity<Collection<Stock>> stock(@RequestParam(value="vehiculoId") Long vehiculoId);

    @GetMapping("/stock")
    ResponseEntity<Collection<Stock>> stockBySucursal(@RequestParam(value="vehiculoId") Long vehiculoId, @RequestParam(value="sucursalId") Long sucursalId);

    @GetMapping("/sucursales/{id}")
    ResponseEntity<Sucursal> sucursal(@PathVariable("id") Long sucursalId);

    @PutMapping("/stock")
    ResponseEntity<Object> ajuste(@RequestBody AjusteDTO ajusteDTO);

}
