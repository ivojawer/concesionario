package com.concesionario.comercial.servicio.implementaciones;

import com.concesionario.comercial.data.*;
import com.concesionario.comercial.domain.dto.AltaVentaDTO;
import com.concesionario.comercial.domain.dto.VentaDTO;
import com.concesionario.comercial.domain.entities.*;
import com.concesionario.comercial.domain.exceptions.RepositoryException;
import com.concesionario.comercial.domain.exceptions.VentaException;
import com.concesionario.comercial.servicio.IVentaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class VentaService implements IVentaService {
    private static Long sucursalCentralId = Long.parseLong("1");
    private final VendedorRepository vendedorRepository;
    private final StockRepository stockRepository;
    private final ClienteRepository clienteRepository;
    private final CatalogoRepository catalogoRepository;
    private final VentaRepository ventaRepository;

    public VentaService(VendedorRepository vendedorRepository, StockRepository stockRepository, ClienteRepository clienteRepository, CatalogoRepository catalogoRepository, VentaRepository ventaRepository) {
        this.vendedorRepository = vendedorRepository;
        this.stockRepository = stockRepository;
        this.clienteRepository = clienteRepository;
        this.catalogoRepository = catalogoRepository;
        this.ventaRepository = ventaRepository;
    }

    @Override
    @Transactional
    public void vender(AltaVentaDTO ventaDTO) throws VentaException {
        try {
            Collection<Stock> stocksVehiculo = stockRepository.findByVehiculoIdAndSucursalWithCentral(
                ventaDTO.getVehiculoId(), ventaDTO.getSucursalId()
            );

            Optional<Stock> stockCentral = stocksVehiculo.stream()
                .filter(unStock -> unStock.getSucursalId().equals(sucursalCentralId))
                .findFirst();
            Optional<Stock> stockSucursal = stocksVehiculo.stream()
                .filter(unStock -> unStock.getSucursalId().equals(ventaDTO.getSucursalId()))
                .findFirst();

            Long sucursalVentaId;
            Integer diasEntrega;

            Sucursal sucursal = stockRepository.findEntregaBySucursal(ventaDTO.getSucursalId());
            if(stockSucursal.isPresent() && stockSucursal.get().getCantidad() > 0){
                sucursalVentaId = ventaDTO.getSucursalId();
                diasEntrega = sucursal.getDiasEntregaLocal();
            } else if(stockCentral.isPresent() && stockCentral.get().getCantidad() > 0) {
                sucursalVentaId = sucursalCentralId;
                diasEntrega = sucursal.getDiasEntregaCentral();
            } else {
                throw new VentaException("No hay stock disponible para el vehículo ID: " + ventaDTO.getVehiculoId());
            }


            Venta venta = new Venta();
            venta.setVehiculoId(ventaDTO.getVehiculoId());

            clienteRepository.findById(ventaDTO.getClienteId()).orElseThrow(() ->
                new VentaException("Cliente no encontrado con ID: " + ventaDTO.getClienteId()));
            venta.setClienteId(ventaDTO.getClienteId());
            
            Vendedor vendedor = vendedorRepository.findById(ventaDTO.getVendedorId()).orElseThrow(() ->
                new VentaException("Vendedor no encontrado con ID: " + ventaDTO.getVendedorId()));
            venta.setVendedor(vendedor);
            venta.setFechaCreacion(new Date());

            Vehiculo vehiculo = catalogoRepository.findVehiculoById(ventaDTO.getVehiculoId());
            venta.setTotal(vehiculo.getSubtotal());

            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.DATE, diasEntrega);

            venta.setFechaEntregaEstimada(cal.getTime());

            ventaRepository.save(venta);

            // como este es el unico efecto cross-servicio aprovecho y lo dejo al final
            // asi no tengo que preocuparme por implementar transacciones distribuidas
            stockRepository.ajuste(ventaDTO.getVehiculoId(), sucursalVentaId, -1);
        } catch (RepositoryException e) {
            throw new VentaException("Error en la venta: " + e.getMessage(), e);
        } catch (VentaException e) {
            throw e;
        } catch (Exception e) {
            throw new VentaException("Error inesperado durante la venta: " + e.getMessage(), e);
        }
    }

    @Override
    public Collection<VentaDTO> findAll() {
        return ventaRepository.findAll().stream().map(VentaDTO::new).collect(Collectors.toList());
    }

    @Override
    public VentaDTO findById(Long ventaId) throws VentaException {
        try {
            return ventaRepository.findById(ventaId)
                .map(VentaDTO::new)
                .orElseThrow(() -> new VentaException("Venta no encontrada con ID: " + ventaId));
        } catch (Exception e) {
            throw new VentaException("Error al obtener venta con ID: " + ventaId, e);
        }
    }
}
