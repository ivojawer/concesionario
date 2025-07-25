package com.concesionario.clientes.data;

import com.concesionario.clientes.domain.entities.Cliente;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends Repository<Cliente, Long> {
    Cliente save(Cliente cliente);
    Optional<Cliente> findById(Long id);
    List<Cliente> findAll();
}
