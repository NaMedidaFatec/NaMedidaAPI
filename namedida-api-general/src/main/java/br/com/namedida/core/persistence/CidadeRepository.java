package br.com.namedida.core.persistence;

import br.com.namedida.domain.Cidade;
import br.com.namedida.domain.Estado;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends GenericRepository<Cidade> {
}
