package com.concesionario.comercial.servicio;

import com.concesionario.comercial.data.*;
import com.concesionario.comercial.domain.dto.AltaServicioMecanicoDTO;
import com.concesionario.comercial.domain.dto.ServicioMecanicoDTO;
import com.concesionario.comercial.domain.entities.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class ServicioMecanicoService implements IServicioMecanicoService {
    private final ClienteRepository clienteRepository;
    private final ServicioMecanicoRepository servicioMecanicoRepository;
    private final CatalogoRepository catalogoRepository;
    private final VendedorRepository vendedorRepository;
    private final VentaRepository ventaRepository;

    public ServicioMecanicoService(ClienteRepository clienteRepository, ServicioMecanicoRepository servicioMecanicoRepository, CatalogoRepository catalogoRepository, VendedorRepository vendedorRepository, VentaRepository ventaRepository) {
        this.clienteRepository = clienteRepository;
        this.servicioMecanicoRepository = servicioMecanicoRepository;
        this.catalogoRepository = catalogoRepository;
        this.vendedorRepository = vendedorRepository;
        this.ventaRepository = ventaRepository;
    }

    @Override
    public void crear(AltaServicioMecanicoDTO servicioMecanicoDTO) {
        ServicioMecanico sm = new ServicioMecanico();

        Cliente cliente = clienteRepository.findById(servicioMecanicoDTO.getClienteId()).orElseThrow();
        Venta venta = ventaRepository.findById(servicioMecanicoDTO.getVentaId()).orElseThrow();
        Vehiculo vehiculo = catalogoRepository.findVehiculoById(venta.getVehiculoId());


        sm.setKilometros(servicioMecanicoDTO.getKilometros());
        sm.setCliente(cliente);

        Calendar cal = Calendar.getInstance();
        cal.setTime(venta.getFechaCreacion());
        cal.add(Calendar.YEAR, vehiculo.getAniosGarantia());

        Boolean enGarantia = cal.getTime().after(new Date());

        sm.setEnGarantia(enGarantia);

        sm.setFechaEntrega(LocalDate.parse(servicioMecanicoDTO.getFechaEntrega()));

        sm.setVehiculoId(vehiculo.getId());

        servicioMecanicoRepository.save(sm);
    }

    @Override
    public Collection<ServicioMecanicoDTO> listarTodos() {
        return List.of();
    }
}
