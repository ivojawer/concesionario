package com.concesionario.servicio_mecanico.data.implementaciones;

import com.concesionario.servicio_mecanico.clients.ClienteClient;
import com.concesionario.servicio_mecanico.data.ClienteRepository;
import com.concesionario.servicio_mecanico.domain.dto.ClienteDTO;
import com.concesionario.servicio_mecanico.domain.exceptions.RepositoryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteRepositoryFeignImpl implements ClienteRepository {
    private final ClienteClient clienteClient;

    public ClienteRepositoryFeignImpl(ClienteClient clienteClient) {
        this.clienteClient = clienteClient;
    }

    @Override
    public Optional<ClienteDTO> findById(Long clienteId) throws RepositoryException {
        try {
            ResponseEntity<ClienteDTO> response = clienteClient.findById(clienteId);
            if (response.getStatusCode().isError()) {
                if(response.getStatusCode() == HttpStatus.NOT_FOUND) {
                    return Optional.empty();
                }
                throw new RepositoryException("Error al obtener cliente con ID: " + clienteId + 
                    ". Código de estado: " + response.getStatusCode());
            }
            return Optional.ofNullable(response.getBody());
        } catch (Exception e) {
            throw new RepositoryException("Error de conexión al obtener cliente con ID: " + clienteId, e);
        }
    }
}
