package com.concesionario.comercial.data.implementaciones;

import com.concesionario.comercial.clients.StockClient;
import com.concesionario.comercial.data.StockRepository;
import com.concesionario.comercial.domain.dto.AjusteDTO;
import com.concesionario.comercial.domain.entities.Sucursal;
import com.concesionario.comercial.domain.entities.Stock;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@Component
public class StockRepositoryFeignImpl implements StockRepository {
    private final StockClient stockClient;

    public StockRepositoryFeignImpl(StockClient stockClient) {
        this.stockClient = stockClient;
    }

    @Override
    public Collection<Stock> findByVehiculoId(Long vehiculoId) {
        ResponseEntity<Collection<Stock>> response = stockClient.stock(vehiculoId);
        if(response.getStatusCode().isError()){
            // ToDo: err handling
            throw new ResponseStatusException(response.getStatusCode(), "Error al obtener stock");
        }
        return response.getBody();
    }

    @Override
    public Sucursal findEntregaBySucursal(Long sucursalId) {
        ResponseEntity<Sucursal> response = stockClient.sucursal(sucursalId);
        if(response.getStatusCode().isError()){
            // ToDo: err handling
            throw new ResponseStatusException(response.getStatusCode(), "Error al obtener sucursal");
        }

        return response.getBody();
    }

    @Override
    public void ajuste(Long vehiculoId, Long sucursalId, Integer cantidadAjuste) {
        ResponseEntity<Object> response = stockClient.ajuste(new AjusteDTO(sucursalId, vehiculoId, cantidadAjuste));
        if(response.getStatusCode().isError()){
            // ToDo: err handling
            throw new ResponseStatusException(response.getStatusCode(), "Error al realizar ajuste");
        }
    }
}
