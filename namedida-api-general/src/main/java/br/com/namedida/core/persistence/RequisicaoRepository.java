package br.com.namedida.core.persistence;

import br.com.namedida.domain.Lote;
import br.com.namedida.domain.Requisicao;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicaoRepository extends GenericRepository<Requisicao> {
}
