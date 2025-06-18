package com.concesionario.catalogo.data;

import com.concesionario.catalogo.domain.entities.Marca;
import com.concesionario.catalogo.domain.entities.Vehiculo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IVehiculoRepository extends Repository<Vehiculo, Long> {
    Optional<Vehiculo> findById(Long id);
    Collection<Vehiculo> findAll();
    List<Vehiculo> findAllByMarca(Marca marca);
    Vehiculo save(Vehiculo vehiculo);
}
