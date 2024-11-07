package com.springboot.backend.crudapp.crud_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.crudapp.crud_backend.entities.solicitud;
import com.springboot.backend.crudapp.crud_backend.repositories.SolicitudRepository;

@Service
public class SolicitudServiceImpl implements SolicitudService{
    private final SolicitudRepository repository;

    public SolicitudServiceImpl(SolicitudRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<solicitud> findAll(){
        return (List) this.repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<solicitud> findById(Long id){
        return this.repository.findById(id);
    }

    @Transactional
    @Override
    public solicitud save(solicitud solicitud){
        return this.repository.save(solicitud);
    }

    @Transactional
    @Override
    public void deleteById(Long id){
        this.repository.deleteById(id);
    }

    // Implementación del nuevo método
    @Transactional(readOnly = true)
    @Override
    public List<solicitud> findByPersonaId(Long idPersona) {
        return this.repository.findByPersonaId(idPersona);
    }
}
