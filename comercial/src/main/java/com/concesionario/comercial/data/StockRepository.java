package com.concesionario.comercial.data;

import com.concesionario.comercial.domain.entities.Sucursal;
import com.concesionario.comercial.domain.entities.Stock;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface StockRepository {
    Collection<Stock> findByVehiculoId(Long vehiculoId);

    Sucursal findEntregaBySucursal(Long sucursalId);

    void ajuste(Long vehiculoId, Long sucursalId, Integer cantidadAjuste);
}
