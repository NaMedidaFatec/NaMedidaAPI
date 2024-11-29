package br.com.namedida.core.validator;

import br.com.namedida.core.persistence.UnidadeEnsinoRefeicaoRepository;
import br.com.namedida.domain.UnidadeEnsinoRefeicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnidadeEnsinoRefeicaoValidator {
    private static UnidadeEnsinoRefeicaoRepository unidadeEnsinoRefeicaoRepository;

    @Autowired
    public void setRequisicaoRepository(UnidadeEnsinoRefeicaoRepository repository) {
        UnidadeEnsinoRefeicaoValidator.unidadeEnsinoRefeicaoRepository = repository;
    }

    public static UnidadeEnsinoRefeicao validate(Long id) throws Exception {
        return unidadeEnsinoRefeicaoRepository.
                findById(id).
                orElseThrow(() -> new Exception("Refeição não encontrada"));
    }
}