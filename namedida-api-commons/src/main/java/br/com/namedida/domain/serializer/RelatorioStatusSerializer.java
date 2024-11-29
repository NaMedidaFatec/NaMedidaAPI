package br.com.namedida.domain.serializer;

import br.com.namedida.domain.enums.RelatorioStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class RelatorioStatusSerializer extends StdSerializer<RelatorioStatus> {

    public RelatorioStatusSerializer() {
        super(RelatorioStatus.class);
    }

    public RelatorioStatusSerializer(Class t) {
        super(t);
    }

    @Override
    public void serialize(RelatorioStatus relatorio, JsonGenerator generator,
                          SerializerProvider serializerProvider)
            throws IOException {

        generator.writeStartObject();
        generator.writeFieldName("id");
        generator.writeString(relatorio.name());
        generator.writeFieldName("descricao");
        generator.writeString(relatorio.getDescricao());
        generator.writeEndObject();
    }
}
