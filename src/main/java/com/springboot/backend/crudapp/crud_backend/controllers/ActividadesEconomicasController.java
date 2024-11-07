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

import com.springboot.backend.crudapp.crud_backend.entities.actividadesEconomicas;
import com.springboot.backend.crudapp.crud_backend.services.ActividadesEconomicasService;




@RestController
@RequestMapping("/api/actividadesEconomicas")
@CrossOrigin(origins = "http://localhost:4200")
public class ActividadesEconomicasController {
    private final ActividadesEconomicasService service;

    public ActividadesEconomicasController(ActividadesEconomicasService service) {
        this.service = service;
    }

    //lista todo
    @GetMapping
    public List<actividadesEconomicas> list() {
        return this.service.findAll();
    }
    
    //busca por id
    @GetMapping("/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {
        Optional<actividadesEconomicas> actiEconomicasOptional = this.service.findById(id);

        if (actiEconomicasOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(actiEconomicasOptional.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "No se encontro Actividad con el id: "+id));
    }
    
    //Crea registro
    @PostMapping
    public ResponseEntity<?> create(@RequestBody actividadesEconomicas actividadesEconomicas) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(actividadesEconomicas));
    }
    
    //actualiza Registro
    @PutMapping("/{id}")
    public ResponseEntity<actividadesEconomicas> update(@PathVariable Long id, @RequestBody actividadesEconomicas actividadesEconomicas) {
        Optional<actividadesEconomicas> actiEOptional = this.service.findById(id);

        if (actiEOptional.isPresent()) {
            actividadesEconomicas actiDB = actiEOptional.get();
            actiDB.setDescripcion(actividadesEconomicas.getDescripcion());

            return ResponseEntity.ok(service.save(actividadesEconomicas));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<actividadesEconomicas> actOption = service.findById(id);

        if (actOption.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }
    
}
