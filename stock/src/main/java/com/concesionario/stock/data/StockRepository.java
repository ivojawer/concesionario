package com.concesionario.stock.data;

import com.concesionario.stock.dominio.dto.StockDTO;
import com.concesionario.stock.dominio.entidades.Stock;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.Optional;

public interface StockRepository extends Repository<Stock, Long> {
    Optional<Stock> findById(Long id);
    Optional<Stock> findByVehiculoIdAndSucursalId(Long vehiculoId, Long sucursal_id);
    void save(Stock stock);
    Collection<Stock> findAll();
    Collection<Stock> findAllByVehiculoId(Long vehiculoId);
}
