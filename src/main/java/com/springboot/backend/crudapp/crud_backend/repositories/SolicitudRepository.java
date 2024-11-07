package com.springboot.backend.crudapp.crud_backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.crudapp.crud_backend.entities.solicitud;

public interface SolicitudRepository extends CrudRepository<solicitud, Long>{
    List<solicitud> findByPersonaId(Long idPersona);
}
