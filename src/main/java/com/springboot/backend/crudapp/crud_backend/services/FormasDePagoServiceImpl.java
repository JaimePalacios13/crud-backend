package com.springboot.backend.crudapp.crud_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.crudapp.crud_backend.entities.formasDePago;
import com.springboot.backend.crudapp.crud_backend.repositories.FormasDePagoRepository;

@Service
public class FormasDePagoServiceImpl implements FormasDePagoService{
    private final FormasDePagoRepository repository;

    public FormasDePagoServiceImpl(FormasDePagoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly=true)
    @Override
    public List<formasDePago> findAll(){
        return (List) this.repository.findAll();
    }

    @Transactional(readOnly=true)
    @Override
    public Optional<formasDePago> findById(Long id){
        return this.repository.findById(id);
    }

    @Transactional
    @Override
    public formasDePago save(formasDePago formasDePago){
        return this.repository.save(formasDePago);
    }

    @Transactional
    @Override
    public void deleteById(Long id){
        this.repository.deleteById(id);
    }
    
}
