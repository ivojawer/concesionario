package com.concesionario.stock.presentacion;

import com.concesionario.stock.dominio.dto.AjusteDTO;
import com.concesionario.stock.dominio.dto.StockDTO;
import com.concesionario.stock.dominio.entidades.Stock;
import com.concesionario.stock.servicio.IStockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("stock")
public class StockController {
    private final IStockService stockService;

    public StockController(IStockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public ResponseEntity<Collection<StockDTO>> findAll(@RequestParam("vehiculoId") String vehiculoIdParam){
        if(vehiculoIdParam != null){
            Long vehiculoId = Long.parseLong(vehiculoIdParam);
            return ResponseEntity.ok(stockService.findAllByVehiculo(vehiculoId));
        }
        return ResponseEntity.ok(stockService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Stock> getById(@PathVariable("id") String id) throws Exception {
        return ResponseEntity.of(Optional.of(stockService.getStock(Long.parseLong(id))));
    }

    @PutMapping
    public ResponseEntity ajuste(@RequestBody AjusteDTO ajusteDTO) {
        stockService.realizarAjuste(ajusteDTO);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
