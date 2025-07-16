package com.concesionario.comercial.data.implementaciones;

import com.concesionario.comercial.clients.ClienteClient;
import com.concesionario.comercial.data.ClienteRepository;
import com.concesionario.comercial.domain.dto.ClienteDTO;
import com.concesionario.comercial.domain.exceptions.NotFoundException;
import com.concesionario.comercial.domain.exceptions.RepositoryException;
import feign.FeignException;
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
                    throw new NotFoundException("No existe el cliente con id " + clienteId);
                }
                throw new RepositoryException("Error al obtener cliente con ID: " + clienteId + 
                    ". Código de estado: " + response.getStatusCode());
            }
            return Optional.ofNullable(response.getBody());
        } catch (RepositoryException e) {
            throw  e;
        } catch (FeignException e){
            if(e.status() == 404){
                throw new NotFoundException("No existe el cliente con id " + clienteId);
            }
            throw new RepositoryException("Error de conexión al obtener cliente con ID: " + clienteId, e);
        }
        catch (Exception e) {
            throw new RepositoryException("Error de conexión al obtener cliente con ID: " + clienteId, e);
        }
    }
}
