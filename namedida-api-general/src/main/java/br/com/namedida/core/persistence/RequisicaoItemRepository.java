package br.com.namedida.core.persistence;

import br.com.namedida.domain.Requisicao;
import br.com.namedida.domain.RequisicaoItem;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicaoItemRepository extends GenericRepository<RequisicaoItem> {
}
