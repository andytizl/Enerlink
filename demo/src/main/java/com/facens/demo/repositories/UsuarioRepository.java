package com.facens.demo.repositories;

import com.facens.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    // O Spring já cria métodos como save(), findById(), deleteById() e findAll() automaticamente.
}
