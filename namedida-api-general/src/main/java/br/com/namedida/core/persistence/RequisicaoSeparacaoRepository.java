package br.com.namedida.core.persistence;

import br.com.namedida.domain.Requisicao;
import br.com.namedida.domain.RequisicaoItem;
import br.com.namedida.domain.RequisicaoSeparacao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequisicaoSeparacaoRepository extends GenericRepository<RequisicaoSeparacao> {
    RequisicaoSeparacao findFirstByRequisicao(Requisicao requisicao);
}
