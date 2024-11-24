package br.com.namedida.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "requisicaoseparacao")
@Entity
public class RequisicaoSeparacao extends EntidadeDominio {

    @NotNull(message = "Observações sobre a separação de suprimentos")
    private String observacoes;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Data da separação do suprimentos")
    private LocalDate data;

    private boolean finalizada;

    @ManyToOne
    private Requisicao requisicao;

    @ManyToOne
    private Usuario separadoPor;

    @Builder(builderMethodName = "requisicaoSeparacaoBuilder")
    public RequisicaoSeparacao(Long id, Boolean enabled, String observacoes, LocalDate data, boolean finalizada, Requisicao requisicao, Usuario separadoPor) {
//        super(id, enabled);
        this.observacoes = observacoes;
        this.data = data;
        this.finalizada = finalizada;
        this.requisicao = requisicao;
        this.separadoPor = separadoPor;
    }
}
