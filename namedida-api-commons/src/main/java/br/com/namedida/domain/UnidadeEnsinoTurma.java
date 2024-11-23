package br.com.namedida.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "turma")
@Entity
public class UnidadeEnsinoTurma extends EntidadeDominio {
    private String nome;
    private Integer quantidade;
    private LocalDate horarioInicial;
    private LocalDate horarioFinal;
    private String sala;

    @ManyToOne
    private UnidadeEnsino unidadeEnsino;

    @Builder(builderMethodName="unidadeensinoturmaBuilder")
    public UnidadeEnsinoTurma(String nome, Integer quantidade, LocalDate horarioInicial, LocalDate horarioFinal, String sala, UnidadeEnsino unidadeEnsino) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.sala = sala;
        this.unidadeEnsino = unidadeEnsino;
    }
}
