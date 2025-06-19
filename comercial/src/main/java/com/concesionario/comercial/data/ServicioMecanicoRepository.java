package com.concesionario.comercial.data;

import com.concesionario.comercial.domain.entities.Cliente;
import com.concesionario.comercial.domain.entities.ServicioMecanico;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ServicioMecanicoRepository extends Repository<ServicioMecanico, Long> {
    ServicioMecanico save(ServicioMecanico servicioMecanico);
    Optional<ServicioMecanico> findById(Long id);
    List<ServicioMecanico> findAll();
}
