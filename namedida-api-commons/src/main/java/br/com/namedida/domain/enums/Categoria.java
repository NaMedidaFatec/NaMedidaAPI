package br.com.namedida.domain.enums;

import br.com.namedida.domain.serializer.CategoriaSerializer;
import br.com.namedida.domain.deserializer.CategoriaDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = CategoriaSerializer.class)
@JsonDeserialize(using = CategoriaDeserializer.class)
public enum Categoria {
    ALIMENTICIOS("Alimentícios"),
    BEBIDAS("Bebidas"),
    HIGIENICOS("Higiénicos"),
    ESPECIAIS("Especiais"),
    INGREDIENTES("Ingredientes"),
    OUTROS("Outros");

    private Categoria(String descricao) {
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