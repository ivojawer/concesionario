package com.concesionario.comercial.servicio;

import com.concesionario.comercial.domain.dto.AltaClienteDTO;

public interface IClienteService {
    void crearCliente(AltaClienteDTO altaClienteDTO);
}
