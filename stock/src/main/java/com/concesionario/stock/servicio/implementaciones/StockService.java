package com.concesionario.stock.servicio.implementaciones;

import com.concesionario.stock.data.StockRepository;
import com.concesionario.stock.dominio.dto.AjusteDTO;
import com.concesionario.stock.dominio.dto.StockDTO;
import com.concesionario.stock.dominio.entidades.Stock;
import com.concesionario.stock.servicio.IStockService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class StockService implements IStockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock getStock(Long id) throws Exception {
        return stockRepository.findById(id).orElseThrow();
    }

    public void realizarAjuste(AjusteDTO ajusteDTO) {
        Stock stock = stockRepository.findByVehiculoIdAndSucursalId(ajusteDTO.getVehiculoId(), ajusteDTO.getSucursalId()).orElseThrow();
        stock.ajustarCantidad(ajusteDTO.getAjusteCantidad());
        stockRepository.save(stock);
    }

    public Collection<StockDTO> findAllByVehiculo(Long vehiculoId) {
        return stockRepository.findAllByVehiculoId(vehiculoId).stream().map(StockDTO::new).collect(Collectors.toList());
    }

    public Collection<StockDTO> findAll() {
        return stockRepository.findAll().stream().map(StockDTO::new).collect(Collectors.toList());
    }
}
