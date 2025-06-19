package com.concesionario.stock.data;

import com.concesionario.stock.dominio.entidades.Localidad;
import com.concesionario.stock.dominio.entidades.Sucursal;
import org.springframework.cglib.core.Local;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface LocalidadRepository extends Repository<Localidad, Long> {
    Localidad save(Localidad localidad);

}
