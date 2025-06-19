package com.concesionario.comercial.clients;

import com.concesionario.comercial.domain.entities.Stock;
import com.concesionario.comercial.domain.entities.Vehiculo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "catalogo")
public interface CatalogoClient {
    @GetMapping("/vehiculos/{id}")
    ResponseEntity<Vehiculo> findVehiculo(@PathVariable("id") Long vehiculoId);

}
