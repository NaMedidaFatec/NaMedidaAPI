package br.com.namedida.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "requisicao")
@Entity
public class Requisicao extends EntidadeDominio {
    @NotNull(message = "Observações sobre a requisição de suprimentos")
    private String observacoes;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Data da requisição de suprimentos")
    private LocalDate data;

    private boolean finalizada;

    @ManyToOne
    private Usuario solicitante;

    @Formula(value = "(getQtdItensPendentes(id))")
    private int qtdItensPendentes;

    @ManyToOne
    private Departamento departamento;

    @ManyToOne
    private UnidadeEnsino unidadeEnsino;

    private String observacoesCancelamento;

    @Builder(builderMethodName = "requisicaoBuilder")
    public Requisicao(Long id, String observacoes, LocalDate data, boolean finalizada, Usuario solicitante, int qtdItensPendentes, Departamento departamento, UnidadeEnsino unidadeEnsino) {
        this.observacoes = observacoes;
        this.data = data;
        this.finalizada = finalizada;
        this.solicitante = solicitante;
        this.qtdItensPendentes = qtdItensPendentes;
        this.departamento = departamento;
        this.unidadeEnsino = unidadeEnsino;
    }
}
