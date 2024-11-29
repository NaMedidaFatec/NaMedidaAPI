package br.com.namedida.core.persistence;

import br.com.namedida.domain.*;

import java.util.List;
import java.util.Optional;

public interface RelatorioRepository extends GenericRepository<Relatorio> {
    List<Relatorio> findAllByUnidadeEnsino(UnidadeEnsino unidadeEnsino);
}
