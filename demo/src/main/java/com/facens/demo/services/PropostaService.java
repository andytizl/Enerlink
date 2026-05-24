package com.facens.demo.services;

import com.facens.demo.models.Proposta;
import com.facens.demo.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PropostaService {
    @Autowired
    private PropostaRepository repository;

    public List<Proposta> listarTodos() { return repository.findAll(); }
    public Optional<Proposta> buscarPorId(String id) { return repository.findById(id); }
    public Proposta salvar(Proposta proposta) { return repository.save(proposta); }
    public void deletar(String id) { repository.deleteById(id); }
}