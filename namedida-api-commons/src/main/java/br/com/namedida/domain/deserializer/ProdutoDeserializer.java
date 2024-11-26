package br.com.namedida.domain.deserializer;

import br.com.namedida.domain.Produto;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.IOException;

public class ProdutoDeserializer extends JsonDeserializer<Produto> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Produto deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        Integer produtoId = parser.getValueAsInt();

        return entityManager.find(Produto.class, produtoId);
    }
}
