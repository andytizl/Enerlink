package com.facens.demo.services;

import com.facens.demo.models.Projeto;
import com.facens.demo.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository repository;

    public List<Projeto> listarTodos() { return repository.findAll(); }
    public Optional<Projeto> buscarPorId(String id) { return repository.findById(id); }
    public Projeto salvar(Projeto projeto) { return repository.save(projeto); }
    public void deletar(String id) { repository.deleteById(id); }
}