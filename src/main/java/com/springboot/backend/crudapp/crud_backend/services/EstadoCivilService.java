package com.springboot.backend.crudapp.crud_backend.services;

import java.util.List;
import java.util.Optional;

import com.springboot.backend.crudapp.crud_backend.entities.estadoCivil;

public interface EstadoCivilService {
    List<estadoCivil> findAll();

    Optional<estadoCivil> findById(Long id);

    estadoCivil save(estadoCivil estadoCivil);

    void deleteById(Long id);
}
