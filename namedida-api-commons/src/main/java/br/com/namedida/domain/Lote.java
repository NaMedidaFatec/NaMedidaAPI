package br.com.namedida.domain;


import br.com.namedida.domain.deserializer.ProdutoDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "lote")
@Entity
public class Lote extends EntidadeDominio {

    @NotNull(message = "A identificação do Lote é obrigatória")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Data de fabricação obrigatória")
    private LocalDate dataFabricacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Data de vencimento obrigatória")
    private LocalDate dataValidade;

    private Double quantidade;

    @ManyToOne
    @JsonDeserialize(using = ProdutoDeserializer.class)
    private Produto produto;

    private Double valorUnitario = 0d;

    @Builder(builderMethodName="loteBuilder")
    public Lote(String nome, LocalDate dataFabricacao, LocalDate dataValidade, Double quantidade, Produto produto, Double valorUnitario) {
        this.nome = nome;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.quantidade = quantidade;
        this.produto = produto;
        this.valorUnitario = valorUnitario;
    }
}
