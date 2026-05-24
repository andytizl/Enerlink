package com.facens.demo.controller;

import com.facens.demo.models.Projeto;
import com.facens.demo.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService service;

    @GetMapping
    public List<Projeto> listar() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> buscar(@PathVariable String id) {
        return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Projeto criar(@RequestBody Projeto projeto) { return service.salvar(projeto); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}