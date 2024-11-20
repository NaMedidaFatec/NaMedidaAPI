package br.com.namedida.core.persistence;

import br.com.namedida.domain.Requisicao;
import br.com.namedida.domain.RequisicaoItem;
import br.com.namedida.domain.UsuarioDepartamento;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RequisicaoItemRepository extends GenericRepository<RequisicaoItem> {
    List<RequisicaoItem> findAllByRequisicao(Requisicao requisicao);
}
