package br.com.namedida.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "refeicao")
@Entity
public class UnidadeEnsinoRefeicao extends EntidadeDominio {
    private String nome;
    private String descricao;

    private LocalTime horarioDisponibilidade;

    @ManyToOne
    private UnidadeEnsino unidadeEnsino;

    @ManyToOne
    private UnidadeEnsinoTurma turma;

    @Builder(builderMethodName="unidadeensinorefeicaoBuilder")
    public UnidadeEnsinoRefeicao(String nome, String descricao, LocalTime horarioDisponibilidade, UnidadeEnsino unidadeEnsino) {
        this.nome = nome;
        this.descricao = descricao;
        this.horarioDisponibilidade = horarioDisponibilidade;
        this.unidadeEnsino = unidadeEnsino;
    }
}
