package com.facens.demo.controller;

import com.facens.demo.controller.DTOs.RequisicaoCriarProposta;
import com.facens.demo.controller.DTOs.RespostaDadosProposta;
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
    public ResponseEntity<List<RespostaDadosProposta>> listar() {
        return ResponseEntity.ok(service.listarTodos().stream()
        .map(proposta -> new RespostaDadosProposta(
                proposta.getId(),
                proposta.getProjeto().getId(),
                proposta.getConsultor().getId(),
                proposta.getEmpresa().getId(),
                proposta.getValor().toString(),
                proposta.getPrazo().toString(),
                proposta.getDescricao(),
                proposta.getStatus(),
                proposta.getDataEnvio().toString()
        )).toList()); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaDadosProposta> buscar(@PathVariable String id) {
        return service.buscarPorId(id).map(proposta -> new RespostaDadosProposta(
                proposta.getId(),
                proposta.getProjeto().getId(),
                proposta.getConsultor().getId(),
                proposta.getEmpresa().getId(),
                proposta.getValor().toString(),
                proposta.getPrazo().toString(),
                proposta.getDescricao(),
                proposta.getStatus(),
                proposta.getDataEnvio().toString()
        )).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RespostaDadosProposta> criar(@RequestBody RequisicaoCriarProposta proposta) {
        var resposta = service.salvar(proposta);
        return ResponseEntity.ok(new RespostaDadosProposta(
                resposta.getId(),
                resposta.getProjeto().getId(),
                resposta.getConsultor().getId(),
                resposta.getEmpresa().getId(),
                resposta.getValor().toString(),
                resposta.getPrazo().toString(),
                resposta.getDescricao(),
                resposta.getStatus(),
                resposta.getDataEnvio().toString()
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
