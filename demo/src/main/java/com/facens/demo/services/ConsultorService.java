package com.facens.demo.services;

import com.facens.demo.models.Consultor;
import com.facens.demo.repositories.ConsultorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultorService {
    @Autowired
    private ConsultorRepository repository;

    public List<Consultor> listarTodos() { return repository.findAll(); }
    public Optional<Consultor> buscarPorId(String id) { return repository.findById(id); }
    public Consultor salvar(Consultor consultor) { return repository.save(consultor); }
    public void deletar(String id) { repository.deleteById(id); }
}