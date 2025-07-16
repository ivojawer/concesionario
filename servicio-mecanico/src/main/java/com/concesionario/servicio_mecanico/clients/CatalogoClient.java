package com.concesionario.servicio_mecanico.clients;

import com.concesionario.servicio_mecanico.domain.dto.Vehiculo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "catalogo")
public interface CatalogoClient {
    @GetMapping("/vehiculos/{id}")
    ResponseEntity<Vehiculo> findVehiculo(@PathVariable("id") Long vehiculoId);

}
