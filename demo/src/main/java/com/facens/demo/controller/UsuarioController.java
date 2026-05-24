package com.facens.demo.controller;

import com.facens.demo.controller.DTOs.RequisicaoCriarUsuario;
import com.facens.demo.controller.DTOs.RespostaDadosUsuario;
import com.facens.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<RespostaDadosUsuario>> listar() {
        return ResponseEntity.ok(usuarioService.listarTodos().stream()
            .map(usuario -> new RespostaDadosUsuario(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getTipoUsuario()
            ))
            .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaDadosUsuario> buscar(@PathVariable String id) {
        return usuarioService.buscarPorId(id)
                .map(usuario -> ResponseEntity.ok(new RespostaDadosUsuario(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getTelefone(),
                        usuario.getTipoUsuario()
                )))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RespostaDadosUsuario> criar(@RequestBody RequisicaoCriarUsuario usuario) {
        var resposta = usuarioService.salvar(usuario);
        return ResponseEntity.ok(new RespostaDadosUsuario(
                resposta.getId(),
                resposta.getNome(),
                resposta.getEmail(),
                resposta.getTelefone(),
                resposta.getTipoUsuario()
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}