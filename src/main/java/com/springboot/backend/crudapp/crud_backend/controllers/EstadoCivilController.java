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

import com.springboot.backend.crudapp.crud_backend.entities.estadoCivil;
import com.springboot.backend.crudapp.crud_backend.services.EstadoCivilService;

@RestController
@RequestMapping("/api/estadoCivil")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoCivilController {

    private final EstadoCivilService service;
    public EstadoCivilController(EstadoCivilService service) {
        this.service = service;
    }
    @GetMapping
    public List<estadoCivil> list() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {
        Optional<estadoCivil> estadoCivilOptional =  this.service.findById(id);

        if(estadoCivilOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(estadoCivilOptional.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "El estado civil no se encontro con id: "+id));
        
    }

    @PostMapping
    public ResponseEntity<estadoCivil> create(@RequestBody estadoCivil estadoCivil) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(estadoCivil));
    }

    @PutMapping("/{id}")
    public ResponseEntity<estadoCivil> update(@PathVariable Long id, @RequestBody estadoCivil estadoCivil) {
        Optional<estadoCivil> estadOptional = service.findById(id);

        if (estadOptional.isPresent()) {
            estadoCivil estadoCivilDb = estadOptional.get();
            estadoCivilDb.setDescripcion(estadoCivil.getDescripcion());
            return ResponseEntity.ok(service.save(estadoCivilDb));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<estadoCivil> estadOptional = service.findById(id);

        if (estadOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    
}
