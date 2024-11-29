package br.com.namedida.core.persistence;

import br.com.namedida.domain.Departamento;
import br.com.namedida.domain.Relatorio;
import br.com.namedida.domain.UnidadeEnsino;
import br.com.namedida.domain.UsuarioUnidadeEnsino;

import java.util.List;
import java.util.Optional;

public interface UsuarioUnidadeEnsinoRepository extends GenericRepository<UsuarioUnidadeEnsino> {
    Optional<UsuarioUnidadeEnsino> findByEmail(String email);
    List<UsuarioUnidadeEnsino> findAllByUnidadeEnsinoDepartamento(Departamento departamento);
}
