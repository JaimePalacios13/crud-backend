package com.springboot.backend.crudapp.crud_backend.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.crudapp.crud_backend.entities.persona;
import com.springboot.backend.crudapp.crud_backend.services.PersonaService;




@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    private final PersonaService service;

    public PersonaController(PersonaService service) {
        this.service = service;
    }

    @GetMapping
    public List<persona> list() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {
        Optional<persona> personaOptional = this.service.findById(id);

        if (personaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(personaOptional.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "no se encontro cliente con id: "+id));
    }

    @PostMapping
    public ResponseEntity<persona> create(@RequestBody persona persona) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(persona));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<persona> update(@PathVariable Long id, @RequestBody persona persona) {
        Optional<persona> persOptional = service.findById(id);

        if (persOptional.isPresent()) {
            persona personaDB = persOptional.get();
            personaDB.setDui(persona.getDui());
            personaDB.setNit(persona.getNit());
            personaDB.setNombres(persona.getNombres());
            personaDB.setApellidos(persona.getApellidos());
            personaDB.setSexo(persona.getSexo());
            personaDB.setActividadEconomica(persona.getActividadEconomica());
            personaDB.setEstadoCivil(persona.getEstadoCivil());

            return ResponseEntity.ok(service.save(personaDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<persona> persOptional = service.findById(id);

        if (persOptional.isPresent()) {
            service.deleteById(id);

            return ResponseEntity.status(HttpStatus.OK).body(persOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    
    
}
