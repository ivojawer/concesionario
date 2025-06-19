package com.concesionario.comercial.servicio;

import com.concesionario.comercial.data.VendedorRepository;
import com.concesionario.comercial.domain.entities.Vendedor;
import org.springframework.stereotype.Service;

@Service
public class VendedorService implements IVendedorService {
    private final VendedorRepository vendedorRepository;

    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @Override
    public void create(Vendedor vendedor) {
        vendedorRepository.save(vendedor);
    }
}
