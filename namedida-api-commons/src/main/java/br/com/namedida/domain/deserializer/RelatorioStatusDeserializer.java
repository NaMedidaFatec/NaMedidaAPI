package br.com.namedida.domain.deserializer;

import br.com.namedida.domain.enums.RelatorioStatus;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class RelatorioStatusDeserializer extends JsonDeserializer<RelatorioStatus> {
    @Override
    public RelatorioStatus deserialize(JsonParser parser, DeserializationContext context)
            throws IOException {

        JsonNode node = parser.getCodec().readTree(parser);

        String value = node.asText();

        for (RelatorioStatus relatorioStatus : RelatorioStatus.values()) {
            if (RelatorioStatus.valueOf(value).equals(relatorioStatus)) {
                return relatorioStatus;
            }
        }

        throw new IllegalArgumentException("Status do relatório desconhecido: " + value);
    }
}
