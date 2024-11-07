package com.springboot.backend.crudapp.crud_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.crudapp.crud_backend.entities.estadoCivil;
import com.springboot.backend.crudapp.crud_backend.repositories.EstadoCivilRepository;

@Service
public class EstadoCivilServiceImpl implements EstadoCivilService{

    private final EstadoCivilRepository repository;

    public EstadoCivilServiceImpl(EstadoCivilRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<estadoCivil> findAll() {
        return (List) this.repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<estadoCivil> findById(@NonNull Long id) {
        return this.repository.findById(id);
    }

    @Transactional
    @Override
    public estadoCivil save(estadoCivil estadoCivil) {
        return this.repository.save(estadoCivil);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

}
