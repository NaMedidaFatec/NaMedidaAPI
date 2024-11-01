package br.com.namedida.core.persistence;

import br.com.namedida.domain.Cidade;
import br.com.namedida.domain.Lote;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository extends GenericRepository<Lote> {
}
