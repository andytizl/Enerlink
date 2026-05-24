package com.facens.demo.controller;

import com.facens.demo.models.Consultor;
import com.facens.demo.services.ConsultorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/consultores")
public class ConsultorController {

    @Autowired
    private ConsultorService service;

    @GetMapping
    public List<Consultor> listar() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public ResponseEntity<Consultor> buscar(@PathVariable String id) {
        return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Consultor criar(@RequestBody Consultor consultor) { return service.salvar(consultor); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}