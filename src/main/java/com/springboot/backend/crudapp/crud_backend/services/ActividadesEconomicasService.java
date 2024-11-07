package com.springboot.backend.crudapp.crud_backend.services;

import java.util.List;
import java.util.Optional;

import com.springboot.backend.crudapp.crud_backend.entities.actividadesEconomicas;

public interface ActividadesEconomicasService {

    List<actividadesEconomicas> findAll();

    Optional<actividadesEconomicas> findById(Long id);

    actividadesEconomicas save(actividadesEconomicas actividadesEconomicas);

    void deleteById(Long id);
}
