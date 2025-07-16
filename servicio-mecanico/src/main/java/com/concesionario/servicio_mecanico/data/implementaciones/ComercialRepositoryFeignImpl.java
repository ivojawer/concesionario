package com.concesionario.servicio_mecanico.data.implementaciones;

import com.concesionario.servicio_mecanico.clients.ComercialClient;
import com.concesionario.servicio_mecanico.data.ComercialRepository;
import com.concesionario.servicio_mecanico.domain.dto.VentaDTO;
import com.concesionario.servicio_mecanico.domain.exceptions.NotFoundException;
import com.concesionario.servicio_mecanico.domain.exceptions.RepositoryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ComercialRepositoryFeignImpl implements ComercialRepository {
    private final ComercialClient comercialClient;

    public ComercialRepositoryFeignImpl(ComercialClient comercialClient) {
        this.comercialClient = comercialClient;
    }

    @Override
    public VentaDTO findVentaById(Long ventaId) throws NotFoundException, RepositoryException {
        try {
            ResponseEntity<VentaDTO> response = comercialClient.findVentaById(ventaId);
            if (response.getStatusCode().isError()) {
                if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                    throw new NotFoundException("Venta no encontrada con ID: " + ventaId);
                }
                throw new RepositoryException("Error al obtener venta con ID: " + ventaId + 
                    ". Código de estado: " + response.getStatusCode());
            }
            
            VentaDTO venta = response.getBody();
            if (venta == null) {
                throw new NotFoundException("Venta no encontrada con ID: " + ventaId);
            }
            
            return venta;
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RepositoryException("Error de conexión al obtener venta con ID: " + ventaId, e);
        }
    }
}
