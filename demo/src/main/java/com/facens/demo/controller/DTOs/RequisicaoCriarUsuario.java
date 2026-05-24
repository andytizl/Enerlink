package com.facens.demo.controller.DTOs;

public record RequisicaoCriarUsuario(
    String nome,
    String email,
    String senha,
    String telefone,
    String tipoUsuario
) {}
