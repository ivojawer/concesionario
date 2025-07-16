package com.concesionario.clientes.servicio.implementaciones;

import com.concesionario.clientes.data.ClienteRepository;
import com.concesionario.clientes.domain.dto.AltaClienteDTO;
import com.concesionario.clientes.domain.dto.ClienteDTO;
import com.concesionario.clientes.domain.entities.Cliente;
import com.concesionario.clientes.servicio.IClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public Optional<ClienteDTO> findById(Long id) {
        return clienteRepository.findById(id).map(ClienteDTO::new);
    }

    @Override
    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream()
                .map(ClienteDTO::new)
                .collect(Collectors.toList());
    }
}
