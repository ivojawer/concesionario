package com.concesionario.comercial.servicio;

import com.concesionario.comercial.data.CatalogoRepository;
import com.concesionario.comercial.data.ClienteRepository;
import com.concesionario.comercial.data.StockRepository;
import com.concesionario.comercial.data.VendedorRepository;
import com.concesionario.comercial.domain.dto.AltaVentaDTO;
import com.concesionario.comercial.domain.entities.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Service
public class VentaService implements IVentaService {
    private static Long sucursalCentralId = Long.parseLong("1");
    private final VendedorRepository vendedorRepository;
    private final StockRepository stockRepository;
    private final ClienteRepository clienteRepository;
    private final CatalogoRepository catalogoRepository;

    public VentaService(VendedorRepository vendedorRepository, StockRepository stockRepository, ClienteRepository clienteRepository, CatalogoRepository catalogoRepository) {
        this.vendedorRepository = vendedorRepository;
        this.stockRepository = stockRepository;
        this.clienteRepository = clienteRepository;
        this.catalogoRepository = catalogoRepository;
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
        Cliente cliente = clienteRepository.findById(ventaDTO.getClienteId()).orElse(null);
        venta.setCliente(cliente);
        Vendedor vendedor = vendedorRepository.findById(ventaDTO.getVendedorId()).orElseThrow();
        venta.setVendedor(vendedor);



        Vehiculo vehiculo = catalogoRepository.findVehiculoById(ventaDTO.getVehiculoId());
        venta.setTotal(vehiculo.getSubtotal());



        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, diasEntrega);

        venta.setFechaEntregaEstimada(cal.getTime());
    }
}
