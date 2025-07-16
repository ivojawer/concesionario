package com.concesionario.servicio_mecanico.data.implementaciones;

import com.concesionario.servicio_mecanico.clients.ClienteClient;
import com.concesionario.servicio_mecanico.data.ClienteRepository;
import com.concesionario.servicio_mecanico.domain.dto.ClienteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Component
public class ClienteRepositoryFeignImpl implements ClienteRepository {
    private final ClienteClient clienteClient;

    public ClienteRepositoryFeignImpl(ClienteClient clienteClient) {
        this.clienteClient = clienteClient;
    }

    @Override
    public Optional<ClienteDTO> findById(Long clienteId) {
        try {
            ResponseEntity<ClienteDTO> response = clienteClient.findById(clienteId);
            if (response.getStatusCode().isError()) {
                throw new ResponseStatusException(response.getStatusCode(), "Error al obtener cliente");
            }
            return Optional.ofNullable(response.getBody());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
