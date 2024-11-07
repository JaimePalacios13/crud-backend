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

import com.springboot.backend.crudapp.crud_backend.entities.formasDePago;
import com.springboot.backend.crudapp.crud_backend.services.FormasDePagoService;




@RestController
@RequestMapping("/api/formaPago")
@CrossOrigin(origins = "http://localhost:4200")
public class FormasDePagoController {

    private final FormasDePagoService service;

    public FormasDePagoController(FormasDePagoService service) {
        this.service = service;
    }

    @GetMapping
    public List<formasDePago> list() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {
        Optional<formasDePago> formaPagoOptional = this.service.findById(id);

        if (formaPagoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(formaPagoOptional.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "No se encontro forma de pago con id: "+id));
    }

    @PostMapping
    public ResponseEntity<formasDePago> create(@RequestBody formasDePago formasDePago) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(formasDePago));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<formasDePago> update(@PathVariable Long id, @RequestBody formasDePago formasDePago) {
        Optional<formasDePago> frmPagoOptional = this.service.findById(id);

        if (frmPagoOptional.isPresent()) {
            formasDePago formasDePagoDB = frmPagoOptional.get();
            formasDePagoDB.setDescripcion(formasDePago.getDescripcion());
            return ResponseEntity.ok(service.save(formasDePagoDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<formasDePago> formasDePagoOptional = service.findById(id);

        if (formasDePagoOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
}
