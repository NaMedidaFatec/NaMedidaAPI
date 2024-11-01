package br.com.namedida.core.persistence;

import br.com.namedida.domain.Departamento;
import br.com.namedida.domain.UnidadeEnsino;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends GenericRepository<Departamento> {
}
