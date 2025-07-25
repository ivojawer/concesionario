package com.concesionario.servicio_mecanico.data;

import com.concesionario.servicio_mecanico.domain.dto.ClienteDTO;
import com.concesionario.servicio_mecanico.domain.exceptions.RepositoryException;

import java.util.Optional;

public interface ClienteRepository {
    Optional<ClienteDTO> findById(Long clienteId) throws RepositoryException;
}
