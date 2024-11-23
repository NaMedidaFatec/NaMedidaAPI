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

        String value = node.asText();

        for (NivelEnsino nivelEnsino : NivelEnsino.values()) {
            if (NivelEnsino.valueOf(value).equals(nivelEnsino)) {
                return nivelEnsino;
            }
        }

        throw new IllegalArgumentException("Nível de ensino desconhecido: " + value);
    }
}
