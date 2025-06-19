package com.concesionario.stock.data;

import com.concesionario.stock.dominio.entidades.Stock;
import com.concesionario.stock.dominio.entidades.Sucursal;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface SucursalRepository extends Repository<Sucursal, Long> {
    Optional<Sucursal> findById(Long id);

    Sucursal save(Sucursal sucursal);
}
