package com.facens.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.demo.controller.DTOs.RequisicaoCriarEmpresa;
import com.facens.demo.models.Empresa;
import com.facens.demo.repositories.EmpresaRepository;
import com.facens.demo.repositories.UsuarioRepository;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Empresa> listarTodos() {
        return repository.findAll();
    }

    public Optional<Empresa> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Empresa salvar(RequisicaoCriarEmpresa empresa) {
        var usuario = usuarioRepository.findById(empresa.idUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        var novaEmpresa = new Empresa();
        novaEmpresa.setCnpj(empresa.cnpj());
        novaEmpresa.setNomeEmpresa(empresa.nomeEmpresa());
        novaEmpresa.setUsuario(usuario);
        return repository.save(novaEmpresa);
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }
}
