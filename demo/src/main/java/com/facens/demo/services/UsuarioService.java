package com.facens.demo.services;

import com.facens.demo.models.Usuario;
import com.facens.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(String id) {
        return usuarioRepository.findById(id);
    }

    public Usuario salvar(Usuario usuario) {
        // Aqui você pode adicionar validações futuramente (ex: criptografar senha)
        return usuarioRepository.save(usuario);
    }

    public void deletar(String id) {
        usuarioRepository.deleteById(id);
    }
}