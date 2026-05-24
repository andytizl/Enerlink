package com.facens.demo.controller;

import com.facens.demo.models.Proposta;
import com.facens.demo.services.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/propostas")
public class PropostaController {

    @Autowired
    private PropostaService service;

    @GetMapping
    public List<Proposta> listar() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public ResponseEntity<Proposta> buscar(@PathVariable String id) {
        return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Proposta criar(@RequestBody Proposta proposta) { return service.salvar(proposta); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
