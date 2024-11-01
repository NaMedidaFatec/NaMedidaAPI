package br.com.namedida.core.persistence;

import br.com.namedida.domain.Produto;
import br.com.namedida.domain.UnidadeEnsino;
import br.com.namedida.domain.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeEnsinoRepository extends GenericRepository<UnidadeEnsino> {
}
