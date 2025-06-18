package com.concesionario.catalogo.data;

import com.concesionario.catalogo.domain.entities.Marca;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface IMarcaRepository extends Repository<Marca, Long> {
    Optional<Marca> findById(Long id);
    Marca save(Marca marca);
}
