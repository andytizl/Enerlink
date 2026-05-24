package com.facens.demo.services;

import com.facens.demo.controller.DTOs.RequisicaoCriarProposta;
import com.facens.demo.models.Proposta;
import com.facens.demo.repositories.ConsultorRepository;
import com.facens.demo.repositories.EmpresaRepository;
import com.facens.demo.repositories.ProjetoRepository;
import com.facens.demo.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository repository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ConsultorRepository consultorRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Proposta> listarTodos() {
        return repository.findAll();
    }

    public Optional<Proposta> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Proposta salvar(RequisicaoCriarProposta proposta) {
        var projeto = projetoRepository.findById(proposta.projetoId())
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        var consultor = consultorRepository.findById(proposta.consultorId())
                .orElseThrow(() -> new RuntimeException("Consultor não encontrado"));

        var empresa = empresaRepository.findById(proposta.empresaId())
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        var novaProposta = new Proposta();
        novaProposta.setProjeto(projeto);
        novaProposta.setConsultor(consultor);
        novaProposta.setEmpresa(empresa);
        novaProposta.setValor(proposta.valor().setScale(2));
        novaProposta.setPrazo(Integer.parseInt(proposta.prazo()));
        novaProposta.setDescricao(proposta.descricao());

        return repository.save(novaProposta);
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }
}