package com.concesionario.stock.data;

import com.concesionario.stock.dominio.entidades.Localidad;
import com.concesionario.stock.dominio.entidades.Pais;
import org.springframework.data.repository.Repository;

public interface PaisRepository extends Repository<Pais, Long> {
    Pais save(Pais localidad);

}
