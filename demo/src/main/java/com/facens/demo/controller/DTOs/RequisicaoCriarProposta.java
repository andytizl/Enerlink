package com.facens.demo.controller.DTOs;

import java.math.BigDecimal;

public record RequisicaoCriarProposta(
        String projetoId,
        String consultorId,
        String empresaId,
        BigDecimal valor,
        String prazo,
        String descricao
) {}
