package com.facens.demo.controller.DTOs;

public record RespostaDadosProjeto(
    String id,
    String idEmpresa,
    String titulo,
    String descricao,
    String localizacao,
    String status,
    String dataPublicacao
) {}

