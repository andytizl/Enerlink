package com.facens.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Propostas")
@Data
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "projeto_id", nullable = false)
    private Projeto projeto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "consultor_id", nullable = false)
    private Consultor consultor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false)
    private Integer prazo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(length = 30)
    private String status = "Pendente";

    @CreationTimestamp
    @Column(name = "data_envio", updatable = false)
    private LocalDateTime dataEnvio;
}