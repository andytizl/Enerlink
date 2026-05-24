package com.facens.demo.controller.DTOs;

public record RespostaDadosProposta(
        String id,
        String projetoId,
        String consultorId,
        String empresaId,
        String valor,
        String prazo,
        String descricao,
        String status,
        String dataEnvio
) {}
