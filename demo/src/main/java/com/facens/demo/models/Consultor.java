package com.facens.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;

@Entity
@Table(name = "Consultores")
@Data
public class Consultor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(length = 100)
    private String especialidade;

    @Column(name = "avaliacao_media", precision = 3, scale = 2)
    private BigDecimal avaliacaoMedia = BigDecimal.ZERO;
}
