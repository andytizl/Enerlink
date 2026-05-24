package com.facens.demo.controller;

import com.facens.demo.controller.DTOs.RequisicaoCriarConsultor;
import com.facens.demo.controller.DTOs.RespostaDadosConsultor;
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
    public ResponseEntity<List<RespostaDadosConsultor>> listar() {
        return ResponseEntity.ok(service.listarTodos().stream()
                .map(consultor -> new RespostaDadosConsultor(
                        consultor.getId(),
                        consultor.getUsuario().getId(),
                        consultor.getEspecialidade(),
                        consultor.getAvaliacaoMedia().toString()
                ))
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaDadosConsultor> buscar(@PathVariable String id) {
        return service.buscarPorId(id).map(consultor -> new RespostaDadosConsultor(
                consultor.getId(),
                consultor.getUsuario().getId(),
                consultor.getEspecialidade(),
                consultor.getAvaliacaoMedia().toString()
        )).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RespostaDadosConsultor> criar(@RequestBody RequisicaoCriarConsultor consultor) {
        var resposta = service.salvar(consultor);

        return ResponseEntity.ok(new RespostaDadosConsultor(
                resposta.getId(),
                resposta.getUsuario().getId(),
                resposta.getEspecialidade(),
                resposta.getAvaliacaoMedia().toString()
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}