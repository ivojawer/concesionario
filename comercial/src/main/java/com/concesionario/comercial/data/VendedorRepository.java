package com.concesionario.comercial.data;

import com.concesionario.comercial.domain.entities.Cliente;
import com.concesionario.comercial.domain.entities.Vendedor;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface VendedorRepository extends Repository<Vendedor, Long> {
    Vendedor save(Vendedor vendedor);
    Optional<Vendedor> findById(Long id);
    List<Vendedor> findAll();
}
