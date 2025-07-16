package com.concesionario.comercial.servicio.implementaciones;

import com.concesionario.comercial.data.*;
import com.concesionario.comercial.domain.dto.AltaVentaDTO;
import com.concesionario.comercial.domain.dto.VentaDTO;
import com.concesionario.comercial.domain.entities.*;
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
    public void vender(AltaVentaDTO ventaDTO) {

        // Esto no es muy performante porque me estoy trayendo todos los stocks
        // del vehiculo para hacer una operacion que solo necesito el de la sucursal y
        // el de central, ToDo optimizar
        Collection<Stock> stocksVehiculo = stockRepository.findByVehiculoId(ventaDTO.getVehiculoId());

        Optional<Stock> stockCentral = stocksVehiculo.stream().filter(unStock -> unStock.getSucursalId().equals(sucursalCentralId)).findFirst();
        Optional<Stock> stockSucursal = stocksVehiculo.stream().filter(unStock -> unStock.getSucursalId().equals(ventaDTO.getSucursalId())).findFirst();

        Long sucursalVentaId;
        Integer diasEntrega;

        // ToDo probablemente quisiera tener la configuracion de entrega por vehiculo/sucursal
        Sucursal sucursal = stockRepository.findEntregaBySucursal(ventaDTO.getSucursalId());
        if(stockSucursal.isPresent() && stockSucursal.get().getCantidad() > 0){
            sucursalVentaId = ventaDTO.getSucursalId();
            diasEntrega = sucursal.getDiasEntregaLocal();
        } else if(stockCentral.isPresent() && stockCentral.get().getCantidad() > 0) {
            sucursalVentaId = sucursalCentralId;
            diasEntrega = sucursal.getDiasEntregaCentral();
        } else {
            // ToDo err handling
            throw new RuntimeException("No hay stock");
        }

        stockRepository.ajuste(ventaDTO.getVehiculoId(), sucursalVentaId, -1);

        Venta venta = new Venta();
        venta.setVehiculoId(ventaDTO.getVehiculoId());
        
        // Validate cliente exists using Feign client
        clienteRepository.findById(ventaDTO.getClienteId()).orElseThrow(() -> 
            new RuntimeException("Cliente no encontrado con ID: " + ventaDTO.getClienteId()));
        venta.setClienteId(ventaDTO.getClienteId());
        
        Vendedor vendedor = vendedorRepository.findById(ventaDTO.getVendedorId()).orElseThrow();
        venta.setVendedor(vendedor);
        venta.setFechaCreacion(new Date());



        Vehiculo vehiculo = catalogoRepository.findVehiculoById(ventaDTO.getVehiculoId());
        venta.setTotal(vehiculo.getSubtotal());



        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, diasEntrega);

        venta.setFechaEntregaEstimada(cal.getTime());

        ventaRepository.save(venta);
    }

    @Override
    public Collection<VentaDTO> findAll() {
        return ventaRepository.findAll().stream().map(VentaDTO::new).collect(Collectors.toList());
    }
}
