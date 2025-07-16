package com.concesionario.comercial.data.implementaciones;

import com.concesionario.comercial.clients.StockClient;
import com.concesionario.comercial.data.StockRepository;
import com.concesionario.comercial.domain.dto.AjusteDTO;
import com.concesionario.comercial.domain.entities.Sucursal;
import com.concesionario.comercial.domain.entities.Stock;
import com.concesionario.comercial.domain.exceptions.NotFoundException;
import com.concesionario.comercial.domain.exceptions.RepositoryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class StockRepositoryFeignImpl implements StockRepository {
    private final StockClient stockClient;

    public StockRepositoryFeignImpl(StockClient stockClient) {
        this.stockClient = stockClient;
    }

    @Override
    public Collection<Stock> findByVehiculoId(Long vehiculoId) throws RepositoryException {
        try {
            ResponseEntity<Collection<Stock>> response = stockClient.stock(vehiculoId);
            if(response.getStatusCode().isError()){
                throw new RepositoryException("Error al obtener stock para vehículo ID: " + vehiculoId + 
                    ". Código de estado: " + response.getStatusCode());
            }
            return response.getBody();
        } catch (Exception e) {
            throw new RepositoryException("Error de conexión al obtener stock para vehículo ID: " + vehiculoId, e);
        }
    }

    @Override
    public Sucursal findEntregaBySucursal(Long sucursalId) throws NotFoundException, RepositoryException {
        try {
            ResponseEntity<Sucursal> response = stockClient.sucursal(sucursalId);
            if(response.getStatusCode().isError()){
                if(response.getStatusCode() == HttpStatus.NOT_FOUND) {
                    throw new NotFoundException("Sucursal no encontrada con ID: " + sucursalId);
                }
                throw new RepositoryException("Error al obtener sucursal con ID: " + sucursalId + 
                    ". Código de estado: " + response.getStatusCode());
            }
            
            Sucursal sucursal = response.getBody();
            if(sucursal == null) {
                throw new NotFoundException("Sucursal no encontrada con ID: " + sucursalId);
            }
            
            return sucursal;
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RepositoryException("Error de conexión al obtener sucursal con ID: " + sucursalId, e);
        }
    }

    @Override
    public void ajuste(Long vehiculoId, Long sucursalId, Integer cantidadAjuste) throws RepositoryException {
        try {
            ResponseEntity<Object> response = stockClient.ajuste(new AjusteDTO(sucursalId, vehiculoId, cantidadAjuste));
            if(response.getStatusCode().isError()){
                throw new RepositoryException("Error al realizar ajuste para vehículo ID: " + vehiculoId + 
                    " en sucursal ID: " + sucursalId + ". Código de estado: " + response.getStatusCode());
            }
        } catch (Exception e) {
            throw new RepositoryException("Error de conexión al realizar ajuste para vehículo ID: " + vehiculoId + 
                " en sucursal ID: " + sucursalId, e);
        }
    }
}
