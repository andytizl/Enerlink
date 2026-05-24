package com.facens.demo.services;

import com.facens.demo.controller.DTOs.RequisicaoCriarConsultor;
import com.facens.demo.models.Consultor;
import com.facens.demo.repositories.ConsultorRepository;
import com.facens.demo.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultorService {

    @Autowired
    private ConsultorRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Consultor> listarTodos() {
        return repository.findAll();
    }

    public Optional<Consultor> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Consultor salvar(RequisicaoCriarConsultor consultor) {
        var usuario = usuarioRepository.findById(consultor.idUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        var avaliacao = consultor.avaliacaoMedia();
        if (avaliacao.compareTo(new BigDecimal("10.00")) > 0)
            avaliacao = new BigDecimal("10.00");



        var novoConsultor = new Consultor();
        novoConsultor.setUsuario(usuario);
        novoConsultor.setCpf(consultor.cpf());
        novoConsultor.setEspecialidade(consultor.especialidade());
        novoConsultor.setAvaliacaoMedia(avaliacao.setScale(2));

        return repository.save(novoConsultor); 
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }
}