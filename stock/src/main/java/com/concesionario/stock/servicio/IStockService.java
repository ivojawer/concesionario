package com.concesionario.stock.servicio;

import com.concesionario.stock.dominio.dto.AjusteDTO;
import com.concesionario.stock.dominio.dto.StockDTO;
import com.concesionario.stock.dominio.entidades.Stock;

import java.util.Collection;

public interface IStockService {
    Stock getStock(Long id) throws Exception;
    void realizarAjuste(AjusteDTO ajusteDTO);
    Collection<StockDTO> findAllByVehiculo(Long vehiculoId);
    Collection<StockDTO> findByVehiculoAndSucursalWithCentral(Long vehiculoId, Long sucursalId);
    Collection<StockDTO> findAll();
}
