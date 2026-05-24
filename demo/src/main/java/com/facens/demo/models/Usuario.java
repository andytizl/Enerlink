package com.facens.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 255)
    private String updateSenha; // 'senha' no banco

    @Column(length = 20)
    private String telefone;

    @Column(name = "tipo_usuario", nullable = false, length = 20)
    private String tipoUsuario;
}
