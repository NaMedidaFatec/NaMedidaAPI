package br.com.namedida.domain.deserializer;

import br.com.namedida.domain.UnidadeEnsino;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.IOException;

public class UnidadeEnsinoDeserializer extends JsonDeserializer<UnidadeEnsino> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UnidadeEnsino deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        Integer unidadeEnsinoId = parser.getValueAsInt();

        return entityManager.find(UnidadeEnsino.class, unidadeEnsinoId);
    }
}
