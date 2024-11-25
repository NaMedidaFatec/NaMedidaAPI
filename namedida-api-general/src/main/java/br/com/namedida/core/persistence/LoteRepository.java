package br.com.namedida.core.persistence;

import br.com.namedida.domain.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface LoteRepository extends GenericRepository<Lote> {
    List<Lote> findAllByProdutoAndQuantidadeGreaterThan(Produto produto, Double quantidade);
}
