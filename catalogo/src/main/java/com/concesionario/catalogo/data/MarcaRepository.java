package com.concesionario.catalogo.data;

import com.concesionario.catalogo.domain.entities.Marca;
import org.springframework.data.repository.Repository;

public interface MarcaRepository extends Repository<Marca, Long> {
    Marca findById(Long id);
    void save(Marca marca);
}
