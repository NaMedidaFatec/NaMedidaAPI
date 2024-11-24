package br.com.namedida.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate horarioInicial;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate horarioFinal;
    private String sala;

    @ManyToOne
    @JsonIgnore
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
