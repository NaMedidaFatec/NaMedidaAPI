package br.com.namedida.core.persistence;

import br.com.namedida.domain.UnidadeEnsinoRefeicao;
import br.com.namedida.domain.UnidadeEnsinoRefeicaoItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadeEnsinoRefeicaoItemRepository extends GenericRepository<UnidadeEnsinoRefeicaoItem> {
    List<UnidadeEnsinoRefeicaoItem> findAllByRefeicao(UnidadeEnsinoRefeicao refeicao);
}
