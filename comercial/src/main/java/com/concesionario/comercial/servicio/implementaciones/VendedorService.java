package com.concesionario.comercial.servicio.implementaciones;

import com.concesionario.comercial.data.VendedorRepository;
import com.concesionario.comercial.domain.dto.AltaVendedorDTO;
import com.concesionario.comercial.domain.entities.Vendedor;
import com.concesionario.comercial.servicio.IVendedorService;
import org.springframework.stereotype.Service;

@Service
public class VendedorService implements IVendedorService {
    private final VendedorRepository vendedorRepository;

    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @Override
    public void create(AltaVendedorDTO vendedorDTO) {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre(vendedorDTO.getNombre());
        vendedorRepository.save(vendedor);
    }
}
