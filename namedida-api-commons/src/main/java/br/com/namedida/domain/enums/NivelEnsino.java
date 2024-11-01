package br.com.namedida.domain.enums;

import br.com.namedida.domain.deserializer.NivelEnsinoDeserializer;
import br.com.namedida.domain.serializer.NivelEnsinoSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = NivelEnsinoSerializer.class)
@JsonDeserialize(using = NivelEnsinoDeserializer.class)
public enum NivelEnsino {
    INFANTIL("Infantil"),
    ENSINO_FUNDAMENTAL("Ensino Fundamental"),
    MEDIO("Ensino Médio"),
    SUPERIOR("Ensino Superior");

    private NivelEnsino(String descricao) {
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