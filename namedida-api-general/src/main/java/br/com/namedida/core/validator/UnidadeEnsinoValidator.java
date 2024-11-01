package br.com.namedida.core.validator;

import br.com.namedida.core.persistence.UnidadeEnsinoRepository;
import br.com.namedida.domain.UnidadeEnsino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnidadeEnsinoValidator {
    private static UnidadeEnsinoRepository unidadeEnsinoRepository;

    @Autowired
    public void setUnidadeEnsinoRepository(UnidadeEnsinoRepository repository) {
        UnidadeEnsinoValidator.unidadeEnsinoRepository = repository;
    }

    public static UnidadeEnsino validate(Long id) throws Exception {
        return unidadeEnsinoRepository.
                findById(id).
                orElseThrow(() -> new Exception("UnidadeEnsino não encontrado"));
    }
}