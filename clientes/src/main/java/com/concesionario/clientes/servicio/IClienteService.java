package com.concesionario.clientes.servicio;

import com.concesionario.clientes.domain.dto.AltaClienteDTO;
import com.concesionario.clientes.domain.dto.ClienteDTO;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    void crearCliente(AltaClienteDTO altaClienteDTO);
    Optional<ClienteDTO> findById(Long id);
    List<ClienteDTO> findAll();
}
