package br.com.namedida.core.persistence;

import br.com.namedida.domain.Requisicao;
import br.com.namedida.domain.RequisicaoItem;
import br.com.namedida.domain.RequisicaoSeparacaoItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequisicaoSeparacaoItemRepository extends GenericRepository<RequisicaoSeparacaoItem> {
    List<RequisicaoSeparacaoItem> findAllByRequisicaoItemAndEnabled(RequisicaoItem requisicaoItem, boolean enabled);
}
