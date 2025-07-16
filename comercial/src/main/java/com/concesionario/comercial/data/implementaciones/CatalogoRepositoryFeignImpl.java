package com.concesionario.comercial.data.implementaciones;

import com.concesionario.comercial.clients.CatalogoClient;
import com.concesionario.comercial.data.CatalogoRepository;
import com.concesionario.comercial.domain.entities.Vehiculo;
import com.concesionario.comercial.domain.exceptions.NotFoundException;
import com.concesionario.comercial.domain.exceptions.RepositoryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CatalogoRepositoryFeignImpl implements CatalogoRepository {
    private final CatalogoClient catalogoClient;

    public CatalogoRepositoryFeignImpl(CatalogoClient catalogoClient) {
        this.catalogoClient = catalogoClient;
    }

    @Override
    public Vehiculo findVehiculoById(Long vehiculoId) throws NotFoundException, RepositoryException {
        try {
            ResponseEntity<Vehiculo> response = catalogoClient.findVehiculo(vehiculoId);
            if(response.getStatusCode().isError()){
                if(response.getStatusCode() == HttpStatus.NOT_FOUND) {
                    throw new NotFoundException("Vehículo no encontrado con ID: " + vehiculoId);
                }
                throw new RepositoryException("Error al obtener vehículo con ID: " + vehiculoId + 
                    ". Código de estado: " + response.getStatusCode());
            }
            
            Vehiculo vehiculo = response.getBody();
            if(vehiculo == null) {
                throw new NotFoundException("Vehículo no encontrado con ID: " + vehiculoId);
            }
            
            return vehiculo;
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RepositoryException("Error de conexión al obtener vehículo con ID: " + vehiculoId, e);
        }
    }
}
