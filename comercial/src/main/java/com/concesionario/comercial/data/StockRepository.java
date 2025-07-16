package com.concesionario.comercial.data;

import com.concesionario.comercial.domain.entities.Sucursal;
import com.concesionario.comercial.domain.entities.Stock;
import com.concesionario.comercial.domain.exceptions.NotFoundException;
import com.concesionario.comercial.domain.exceptions.RepositoryException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface StockRepository {
    Collection<Stock> findByVehiculoId(Long vehiculoId) throws RepositoryException;

    Sucursal findEntregaBySucursal(Long sucursalId) throws NotFoundException, RepositoryException;

    void ajuste(Long vehiculoId, Long sucursalId, Integer cantidadAjuste) throws RepositoryException;
}
