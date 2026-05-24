package com.facens.demo.controller.DTOs;

public record RespostaDadosUsuario(
    String id,
    String nome,
    String email,
    String telefone,
    String tipoUsuario
) {}
