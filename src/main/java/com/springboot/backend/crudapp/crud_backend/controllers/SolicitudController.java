package com.springboot.backend.crudapp.crud_backend.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.springboot.backend.crudapp.crud_backend.entities.solicitud;
import com.springboot.backend.crudapp.crud_backend.services.SolicitudService;


@RestController
@RequestMapping("/api/solicitud")
@CrossOrigin(origins = "http://localhost:4200")
public class SolicitudController {
    private final SolicitudService service;

    public SolicitudController(SolicitudService service) {
        this.service = service;
    }

    @GetMapping
    public List<solicitud> list() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {
        Optional<solicitud> solicitudOptional = this.service.findById(id);

        if (solicitudOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(solicitudOptional.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "no se encontro solicitud con id: "+id));
    }

    @PostMapping
    public ResponseEntity<solicitud> create(@RequestBody solicitud solicitud) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(solicitud));
    }

    @PutMapping("/{id}")
    public ResponseEntity<solicitud> update(@PathVariable Long id, @RequestBody solicitud solicitud) {
        Optional<solicitud> solOptional = service.findById(id);

        if (solOptional.isPresent()) {
            solicitud solDB = solOptional.get();
            solDB.setPersona(solicitud.getPersona());
            solDB.setFecha_creacion(solicitud.getFecha_creacion());
            solDB.setMonto(solicitud.getMonto());
            solDB.setPlazo(solicitud.getPlazo());
            solDB.setFormasDePago(solicitud.getFormasDePago());

            return ResponseEntity.ok(service.save(solDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<solicitud> solicitudOptional = service.findById(id);

        if (solicitudOptional.isPresent()) {
            service.deleteById(id);

            return ResponseEntity.status(HttpStatus.OK).body(solicitudOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Endpoint para obtener solicitudes por id_persona
    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<Map<String, Object>>> getSolicitudesByCliente(@PathVariable Long idCliente) {
    List<solicitud> solicitudes = service.findByPersonaId(idCliente);

    // Mapear las solicitudes y devolver solo los campos necesarios
    List<Map<String, Object>> solicitudesSimplificadas = solicitudes.stream().map(sol -> {
        Map<String, Object> solicitudMap = new HashMap<>();
        solicitudMap.put("formasDePago", Map.of(
            "id", sol.getFormasDePago().getId(),
            "descripcion", sol.getFormasDePago().getDescripcion()
        ));
        solicitudMap.put("fecha_creacion", sol.getFecha_creacion());
        solicitudMap.put("monto", sol.getMonto());
        solicitudMap.put("plazo", sol.getPlazo());
        solicitudMap.put("id", sol.getId());
        return solicitudMap;
    }).toList();

    return ResponseEntity.ok(solicitudesSimplificadas);
}

}
