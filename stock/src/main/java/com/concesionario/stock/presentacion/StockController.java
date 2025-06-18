package com.concesionario.stock.presentacion;

import com.concesionario.stock.dominio.entidades.Stock;
import com.concesionario.stock.servicio.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stock")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("{id}")
    public Stock getById(@PathVariable("id") String id) throws Exception {
        return stockService.getStock(Integer.parseInt(id));
    }
}
