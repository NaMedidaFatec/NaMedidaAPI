package br.com.namedida.domain.deserializer;

import br.com.namedida.domain.enums.Categoria;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class CategoriaDeserializer extends JsonDeserializer<Categoria> {
    @Override
    public Categoria deserialize(JsonParser parser, DeserializationContext context)
            throws IOException {

        JsonNode node = parser.getCodec().readTree(parser);

        String descricao = node.get("descricao").asText();

        for (Categoria categoria : Categoria.values()) {
            if (categoria.getDescricao().equals(descricao)) {
                return categoria;
            }
        }

        throw new IllegalArgumentException("Categoria desconhecida: " + descricao);
    }
}
