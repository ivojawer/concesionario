package com.concesionario.stock.data;

import com.concesionario.stock.dominio.entidades.Localidad;
import com.concesionario.stock.dominio.entidades.Provincia;
import org.springframework.data.repository.Repository;

public interface ProvinciaRepository extends Repository<Provincia, Long> {
    Provincia save(Provincia localidad);

}
