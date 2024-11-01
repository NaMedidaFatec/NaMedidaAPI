package br.com.namedida.domain.deserializer;

import br.com.namedida.domain.enums.NivelEnsino;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class NivelEnsinoDeserializer extends JsonDeserializer<NivelEnsino> {
    @Override
    public NivelEnsino deserialize(JsonParser parser, DeserializationContext context)
            throws IOException {

        JsonNode node = parser.getCodec().readTree(parser);

        String descricao = node.get("descricao").asText();

        for (NivelEnsino nivelEnsino : NivelEnsino.values()) {
            if (nivelEnsino.getDescricao().equals(descricao)) {
                return nivelEnsino;
            }
        }

        throw new IllegalArgumentException("Nível de ensino desconhecido: " + descricao);
    }
}
