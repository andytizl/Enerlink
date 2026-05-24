package com.facens.demo.controller;

import com.facens.demo.controller.DTOs.RequisicaoCriarProjeto;
import com.facens.demo.controller.DTOs.RespostaDadosProjeto;
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
    public ResponseEntity<List<RespostaDadosProjeto>> listar() {
        return ResponseEntity.ok(service.listarTodos().stream()
                .map(projeto -> new RespostaDadosProjeto(
                        projeto.getId(),
                        projeto.getEmpresa().getId(),
                        projeto.getTitulo(),
                        projeto.getDescricao(),
                        projeto.getLocalizacao(),
                        projeto.getStatus(),
                        projeto.getDataPublicacao().toString()
                ))
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaDadosProjeto> buscar(@PathVariable String id) {
        return service.buscarPorId(id).map(projeto -> new RespostaDadosProjeto(
                projeto.getId(),
                projeto.getEmpresa().getId(),
                projeto.getTitulo(),
                projeto.getDescricao(),
                projeto.getLocalizacao(),
                projeto.getStatus(),
                projeto.getDataPublicacao().toString()
        )).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RespostaDadosProjeto> criar(@RequestBody RequisicaoCriarProjeto projeto) {
        var resposta = service.salvar(projeto);

        return ResponseEntity.ok(new RespostaDadosProjeto(
                resposta.getId(),
                resposta.getEmpresa().getId(),
                resposta.getTitulo(),
                resposta.getDescricao(),
                resposta.getLocalizacao(),
                resposta.getStatus(),
                resposta.getDataPublicacao().toString()
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}