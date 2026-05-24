package com.facens.demo.controller.DTOs;

import java.math.BigDecimal;

public record RequisicaoCriarConsultor(
    String idUsuario,
    String cpf,
    String especialidade,
    BigDecimal avaliacaoMedia
) {}
