package com.concesionario.servicio_mecanico.servicio.implementaciones;

import com.concesionario.servicio_mecanico.data.CatalogoRepository;
import com.concesionario.servicio_mecanico.data.ClienteRepository;
import com.concesionario.servicio_mecanico.data.ComercialRepository;
import com.concesionario.servicio_mecanico.data.ServicioMecanicoRepository;
import com.concesionario.servicio_mecanico.domain.dto.AltaServicioMecanicoDTO;
import com.concesionario.servicio_mecanico.domain.dto.ClienteDTO;
import com.concesionario.servicio_mecanico.domain.dto.ServicioMecanicoDTO;
import com.concesionario.servicio_mecanico.domain.dto.Vehiculo;
import com.concesionario.servicio_mecanico.domain.dto.VentaDTO;
import com.concesionario.servicio_mecanico.domain.entities.ServicioMecanico;
import com.concesionario.servicio_mecanico.domain.exceptions.NotFoundException;
import com.concesionario.servicio_mecanico.domain.exceptions.RepositoryException;
import com.concesionario.servicio_mecanico.domain.exceptions.ServiceLayerException;
import com.concesionario.servicio_mecanico.servicio.IServicioMecanicoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicioMecanicoService implements IServicioMecanicoService {
    private final ServicioMecanicoRepository servicioMecanicoRepository;
    private final ClienteRepository clienteRepository;
    private final CatalogoRepository catalogoRepository;
    private final ComercialRepository comercialRepository;

    public ServicioMecanicoService(ServicioMecanicoRepository servicioMecanicoRepository, ClienteRepository clienteRepository, CatalogoRepository catalogoRepository, ComercialRepository comercialRepository) {
        this.servicioMecanicoRepository = servicioMecanicoRepository;
        this.clienteRepository = clienteRepository;
        this.catalogoRepository = catalogoRepository;
        this.comercialRepository = comercialRepository;
    }

    @Override
    public void crear(AltaServicioMecanicoDTO servicioMecanicoDTO) throws ServiceLayerException {
        try {
            ServicioMecanico sm = new ServicioMecanico();

            // verificar existencia cliente
            Optional<ClienteDTO> cliente = clienteRepository.findById(servicioMecanicoDTO.getClienteId());
            if (cliente.isEmpty()) {
                throw new ServiceLayerException("El cliente no existe");
            }

            // obtener venta y verificar existencia
            VentaDTO venta = comercialRepository.findVentaById(servicioMecanicoDTO.getVentaId());

            // obtener vehiculo de la venta y verificar existencia
            Vehiculo vehiculo = catalogoRepository.findVehiculoById(venta.getVehiculoId());


            sm.setVehiculoId(venta.getVehiculoId());
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(venta.getFechaCreacion());
            cal.add(Calendar.YEAR, vehiculo.getAniosGarantia());
            
            Date fechaVencimientoGarantia = cal.getTime();
            Date now = new Date();
            sm.setEnGarantia(fechaVencimientoGarantia.after(now));

            sm.setKilometros(servicioMecanicoDTO.getKilometros());
            sm.setClienteId(servicioMecanicoDTO.getClienteId());

            // Una de las correcciones era que esto tenia que ser calculado
            // no entendi muy bien en base a que, tal vez entendi mal y esto
            // era cuando el vehiculo era entregado para EMPEZAR el servicio mecanico
            // en ese caso la fecha entrega seria ahora
            sm.setFechaEntrega(LocalDate.now());

            servicioMecanicoRepository.save(sm);
        } catch (NotFoundException e) {
            throw new ServiceLayerException("Recurso no encontrado: " + e.getMessage());
        } catch (RepositoryException e) {
            throw new ServiceLayerException("Error en la capa de datos: " + e.getMessage());
        } catch (ServiceLayerException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceLayerException("Error inesperado: " + e.getMessage());
        }
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
