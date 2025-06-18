package com.concesionario.stock.servicio;

import com.concesionario.stock.data.StockRepository;
import com.concesionario.stock.dominio.entidades.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock getStock(Integer id) throws Exception {
        Stock stock = stockRepository.findById(id);
        if(stock == null){
            throw new Exception("Stock not found");
        }
        return stock;
    }
}
