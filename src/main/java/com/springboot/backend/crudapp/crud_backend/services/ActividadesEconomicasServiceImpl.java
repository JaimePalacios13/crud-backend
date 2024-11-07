package com.springboot.backend.crudapp.crud_backend.services;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.crudapp.crud_backend.repositories.ActividadesEconomicasRepository;
import com.springboot.backend.crudapp.crud_backend.entities.actividadesEconomicas;

@Service
public class ActividadesEconomicasServiceImpl implements ActividadesEconomicasService{

    public final ActividadesEconomicasRepository repository;

    public ActividadesEconomicasServiceImpl(ActividadesEconomicasRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<actividadesEconomicas> findAll() {
        return (List) this.repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<actividadesEconomicas> findById(Long id) {
        return this.repository.findById(id);
    }

    @Transactional
    @Override
    public actividadesEconomicas save(actividadesEconomicas actividadesEconomicas) {
        return this.repository.save(actividadesEconomicas);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
}
