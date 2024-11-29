package br.com.namedida.core.validator;
import br.com.namedida.core.persistence.UnidadeEnsinoRefeicaoItemRepository;
import br.com.namedida.domain.UnidadeEnsinoRefeicaoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnidadeEnsinoRefeicaoItemValidator {
    private static UnidadeEnsinoRefeicaoItemRepository refeicaoItemRepository;

    @Autowired
    public void setUnidadeEnsinoUnidadeEnsinoRefeicaoItemRepository(UnidadeEnsinoRefeicaoItemRepository repository) {
        UnidadeEnsinoRefeicaoItemValidator.refeicaoItemRepository = repository;
    }

    public static UnidadeEnsinoRefeicaoItem validate(Long id) throws Exception {
        return refeicaoItemRepository.
                findById(id).
                orElseThrow(() -> new Exception("Item da refeição não encontrado"));
    }
}