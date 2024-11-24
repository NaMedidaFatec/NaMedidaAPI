package br.com.namedida.core.persistence;

import br.com.namedida.domain.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoteRepository extends GenericRepository<Lote> {
    List<Lote> findAllByProduto(Produto produto);

}
