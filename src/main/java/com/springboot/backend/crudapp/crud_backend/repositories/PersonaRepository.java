package com.springboot.backend.crudapp.crud_backend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.crudapp.crud_backend.entities.persona;

public interface PersonaRepository extends CrudRepository<persona,Long> {

}
