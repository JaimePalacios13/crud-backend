package com.springboot.backend.crudapp.crud_backend.services;

import java.util.List;
import java.util.Optional;

import com.springboot.backend.crudapp.crud_backend.entities.formasDePago;

public interface FormasDePagoService {

    List<formasDePago> findAll();
    Optional<formasDePago> findById(Long id);
    formasDePago save(formasDePago formasDePago);
    void deleteById(Long id);
}
