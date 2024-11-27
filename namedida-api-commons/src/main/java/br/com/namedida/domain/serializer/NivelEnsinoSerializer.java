package br.com.namedida.domain.serializer;

import br.com.namedida.domain.enums.NivelEnsino;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class NivelEnsinoSerializer extends StdSerializer<NivelEnsino> {

    public NivelEnsinoSerializer() {
        super(NivelEnsino.class);
    }

    public NivelEnsinoSerializer(Class t) {
        super(t);
    }

    @Override
    public void serialize(NivelEnsino nivelEnsino, JsonGenerator generator,
                          SerializerProvider serializerProvider)
            throws IOException {

        generator.writeStartObject();
        generator.writeFieldName("id");
        generator.writeString(nivelEnsino.name());
        generator.writeFieldName("descricao");
        generator.writeString(nivelEnsino.getDescricao());
        generator.writeEndObject();
    }
}
