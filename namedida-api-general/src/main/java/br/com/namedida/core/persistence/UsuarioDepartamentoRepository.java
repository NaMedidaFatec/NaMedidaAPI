package br.com.namedida.core.persistence;

import br.com.namedida.domain.Usuario;
import br.com.namedida.domain.UsuarioDepartamento;

import java.util.Optional;

public interface UsuarioDepartamentoRepository extends GenericRepository<UsuarioDepartamento> {
    Optional<UsuarioDepartamento> findByEmailAndPassword(String email, String password);
}
