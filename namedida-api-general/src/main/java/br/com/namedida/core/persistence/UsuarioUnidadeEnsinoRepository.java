package br.com.namedida.core.persistence;

import br.com.namedida.domain.UsuarioDepartamento;
import br.com.namedida.domain.UsuarioUnidadeEnsino;

import java.util.Optional;

public interface UsuarioUnidadeEnsinoRepository extends GenericRepository<UsuarioUnidadeEnsino> {
    Optional<UsuarioUnidadeEnsino> findByEmailAndPassword(String email, String password);
}
