package br.com.namedida.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "refeicao")
@Entity
public class UnidadeEnsinoRefeicao extends EntidadeDominio {
    private String nome;
    private String descricao;
    private LocalDateTime horarioDisponibilidade;

    @ManyToOne
    @JsonIgnore
    private UnidadeEnsino unidadeEnsino;

    @Builder(builderMethodName="unidadeensinorefeicaoBuilder")
    public UnidadeEnsinoRefeicao(String nome, String descricao, LocalDateTime horarioDisponibilidade, UnidadeEnsino unidadeEnsino) {
        this.nome = nome;
        this.descricao = descricao;
        this.horarioDisponibilidade = horarioDisponibilidade;
        this.unidadeEnsino = unidadeEnsino;
    }
}
