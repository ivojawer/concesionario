package com.concesionario.comercial.data;

import com.concesionario.comercial.domain.entities.Cliente;
import com.concesionario.comercial.domain.entities.Venta;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface VentaRepository extends Repository<Venta, Long> {
    Venta save(Venta venta);
    Optional<Venta> findById(Long id);
    List<Venta> findAll();
}
