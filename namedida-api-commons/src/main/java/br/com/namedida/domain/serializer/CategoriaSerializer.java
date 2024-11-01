package br.com.namedida.domain.serializer;

import br.com.namedida.domain.enums.Categoria;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CategoriaSerializer extends StdSerializer<Categoria> {

    public CategoriaSerializer() {
        super(Categoria.class);
    }

    public CategoriaSerializer(Class t) {
        super(t);
    }

    @Override
    public void serialize(Categoria categoria, JsonGenerator generator,
                          SerializerProvider serializerProvider)
            throws IOException {

        generator.writeStartObject();
        generator.writeFieldName("id");
        generator.writeString(categoria.name());
        generator.writeFieldName("descricao");
        generator.writeString(categoria.getDescricao());
        generator.writeEndObject();
    }
}
