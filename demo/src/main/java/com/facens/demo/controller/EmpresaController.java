package com.facens.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.demo.controller.DTOs.RequisicaoCriarEmpresa;
import com.facens.demo.controller.DTOs.RespostaDadosEmpresa;
import com.facens.demo.services.EmpresaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<RespostaDadosEmpresa>> Listar() {
        return ResponseEntity.ok(empresaService.listarTodos().stream()
            .map(empresa -> new RespostaDadosEmpresa(
                empresa.getId(),
                empresa.getNomeEmpresa(),
                empresa.getUsuario().getId()
            ))
            .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaDadosEmpresa> buscar(@PathVariable String id) {
        return empresaService.buscarPorId(id)
                .map(empresa -> ResponseEntity.ok(new RespostaDadosEmpresa(
                        empresa.getId(),
                        empresa.getNomeEmpresa(),
                        empresa.getUsuario().getId()
                )))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RespostaDadosEmpresa> criar(@RequestBody RequisicaoCriarEmpresa empresa) {
        var resposta = empresaService.salvar(empresa);
        return ResponseEntity.ok(new RespostaDadosEmpresa(
                resposta.getId(),
                resposta.getNomeEmpresa(),
                resposta.getUsuario().getId()
        ));
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        empresaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    
}
