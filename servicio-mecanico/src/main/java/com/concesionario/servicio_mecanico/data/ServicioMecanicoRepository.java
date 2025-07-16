package com.concesionario.servicio_mecanico.data;

import com.concesionario.servicio_mecanico.domain.entities.ServicioMecanico;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ServicioMecanicoRepository extends Repository<ServicioMecanico, Long> {
    ServicioMecanico save(ServicioMecanico servicioMecanico);
    Optional<ServicioMecanico> findById(Long id);
    List<ServicioMecanico> findAll();
    List<ServicioMecanico> findByClienteId(Long clienteId);
}
