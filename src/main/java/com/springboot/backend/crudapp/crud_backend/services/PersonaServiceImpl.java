package com.springboot.backend.crudapp.crud_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.crudapp.crud_backend.entities.persona;
import com.springboot.backend.crudapp.crud_backend.repositories.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository repository;

    public PersonaServiceImpl(PersonaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<persona> findAll(){
        return (List) this.repository.findAll();
    }

    @Transactional(readOnly=true)
    @Override
    public Optional<persona> findById(Long id){
        return this.repository.findById(id);
    }

    @Transactional
    @Override
    public persona save(persona persona){
        return this.repository.save(persona);
    }

    @Transactional
    @Override
    public void deleteById(Long id){
        this.repository.deleteById(id);
    }
}
