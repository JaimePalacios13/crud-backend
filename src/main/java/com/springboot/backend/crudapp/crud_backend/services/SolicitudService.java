package com.springboot.backend.crudapp.crud_backend.services;

import java.util.List;
import java.util.Optional;

import com.springboot.backend.crudapp.crud_backend.entities.solicitud;

public interface SolicitudService {
    List<solicitud> findAll();
    Optional<solicitud> findById(Long id);
    solicitud save(solicitud solicitud);
    void deleteById(Long id);

    // Nuevo método para buscar solicitudes por id_persona
    List<solicitud> findByPersonaId(Long idPersona);
}
