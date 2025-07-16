package com.concesionario.servicio_mecanico.data.implementaciones;

import com.concesionario.servicio_mecanico.clients.CatalogoClient;
import com.concesionario.servicio_mecanico.data.CatalogoRepository;
import com.concesionario.servicio_mecanico.domain.dto.Vehiculo;
import com.concesionario.servicio_mecanico.domain.exceptions.NotFoundException;
import com.concesionario.servicio_mecanico.domain.exceptions.RepositoryException;
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
