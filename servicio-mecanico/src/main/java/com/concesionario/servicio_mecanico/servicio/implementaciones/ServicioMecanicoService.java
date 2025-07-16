package com.concesionario.servicio_mecanico.servicio.implementaciones;

import com.concesionario.servicio_mecanico.data.ClienteRepository;
import com.concesionario.servicio_mecanico.data.ServicioMecanicoRepository;
import com.concesionario.servicio_mecanico.domain.dto.AltaServicioMecanicoDTO;
import com.concesionario.servicio_mecanico.domain.dto.ClienteDTO;
import com.concesionario.servicio_mecanico.domain.dto.ServicioMecanicoDTO;
import com.concesionario.servicio_mecanico.domain.entities.ServicioMecanico;
import com.concesionario.servicio_mecanico.servicio.IServicioMecanicoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioMecanicoService implements IServicioMecanicoService {
    private final ServicioMecanicoRepository servicioMecanicoRepository;
    private final ClienteRepository clienteRepository;

    public ServicioMecanicoService(ServicioMecanicoRepository servicioMecanicoRepository, ClienteRepository clienteRepository) {
        this.servicioMecanicoRepository = servicioMecanicoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void crear(AltaServicioMecanicoDTO servicioMecanicoDTO) {
        ServicioMecanico sm = new ServicioMecanico();

        // Verify cliente exists
        ClienteDTO cliente = clienteRepository.findById(servicioMecanicoDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        sm.setKilometros(servicioMecanicoDTO.getKilometros());
        sm.setClienteId(servicioMecanicoDTO.getClienteId());
        sm.setFechaEntrega(LocalDate.parse(servicioMecanicoDTO.getFechaEntrega()));

        // For now, we'll set default values for guarantee and vehiculoId
        // In a real scenario, these would come from business logic or external services
        sm.setEnGarantia(false); // Default to false, can be updated with business logic
        sm.setVehiculoId(1L); // Default value, should come from venta service

        servicioMecanicoRepository.save(sm);
    }

    @Override
    public Collection<ServicioMecanicoDTO> listarTodos() {
        return servicioMecanicoRepository.findAll().stream()
                .map(ServicioMecanicoDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ServicioMecanicoDTO> listarPorCliente(Long clienteId) {
        return servicioMecanicoRepository.findByClienteId(clienteId).stream()
                .map(ServicioMecanicoDTO::new)
                .collect(Collectors.toList());
    }
}
