package com.concesionario.comercial.data;

import com.concesionario.comercial.domain.dto.ClienteDTO;
import com.concesionario.comercial.domain.exceptions.RepositoryException;

import java.util.Optional;

public interface ClienteRepository {
    Optional<ClienteDTO> findById(Long clienteId) throws RepositoryException;
}
