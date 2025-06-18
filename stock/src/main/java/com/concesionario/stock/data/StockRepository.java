package com.concesionario.stock.data;

import com.concesionario.stock.dominio.entidades.Stock;
import org.springframework.data.repository.Repository;

public interface StockRepository extends Repository<Stock, Integer> {
    Stock findById(Integer id);
}
