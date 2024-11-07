package com.springboot.backend.crudapp.crud_backend.services;

import java.util.List;
import java.util.Optional;

import com.springboot.backend.crudapp.crud_backend.entities.persona;

public interface PersonaService {

    List<persona> findAll();
    Optional<persona> findById(Long id);
    persona save(persona persona);
    void deleteById(Long id);
}
