package br.com.namedida.domain.enums;

import br.com.namedida.domain.deserializer.RelatorioStatusDeserializer;
import br.com.namedida.domain.serializer.RelatorioStatusSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = RelatorioStatusSerializer.class)
@JsonDeserialize(using = RelatorioStatusDeserializer.class)
public enum RelatorioStatus {
    EM_ANALISE("Em análise"),
    APROVADO("Aprovado"),
    REPROVADO("Reprovado");

    private RelatorioStatus(String descricao) {
        this.descricao = descricao;
    }

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return name();
    }
}