package br.com.namedida.core.persistence;

import br.com.namedida.domain.UsuarioUnidadeEnsino;

import java.util.Optional;

public interface UsuarioUnidadeEnsinoRepository extends GenericRepository<UsuarioUnidadeEnsino> {
    Optional<UsuarioUnidadeEnsino> findByEmail(String email);
}
