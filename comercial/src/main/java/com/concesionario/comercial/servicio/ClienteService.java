package com.concesionario.comercial.servicio;

import com.concesionario.comercial.data.ClienteRepository;
import com.concesionario.comercial.domain.dto.AltaClienteDTO;
import com.concesionario.comercial.domain.entities.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void crearCliente(AltaClienteDTO altaClienteDTO) {
        Cliente c = new Cliente();

        c.setEmail(altaClienteDTO.getEmail());
        c.setNombre(altaClienteDTO.getNombre());
        c.setTelefono(altaClienteDTO.getTelefono());

        clienteRepository.save(c);
    }
}
