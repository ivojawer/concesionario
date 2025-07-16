package com.concesionario.comercial.data.implementaciones;

import com.concesionario.comercial.clients.CatalogoClient;
import com.concesionario.comercial.data.CatalogoRepository;
import com.concesionario.comercial.domain.entities.Vehiculo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class CatalogoRepositoryFeignImpl implements CatalogoRepository {
    private final CatalogoClient catalogoClient;

    public CatalogoRepositoryFeignImpl(CatalogoClient catalogoClient) {
        this.catalogoClient = catalogoClient;
    }

    @Override
    public Vehiculo findVehiculoById(Long vehiculoId) {
        ResponseEntity<Vehiculo> response = catalogoClient.findVehiculo(vehiculoId);
        if(response.getStatusCode().isError()){
            throw new ResponseStatusException(response.getStatusCode(), "Error al obtener vehículo");
        }
        return response.getBody();
    }
}
