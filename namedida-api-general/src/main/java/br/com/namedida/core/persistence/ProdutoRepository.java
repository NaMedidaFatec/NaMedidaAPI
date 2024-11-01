package br.com.namedida.core.persistence;

import br.com.namedida.domain.Cidade;
import br.com.namedida.domain.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends GenericRepository<Produto> {
}
