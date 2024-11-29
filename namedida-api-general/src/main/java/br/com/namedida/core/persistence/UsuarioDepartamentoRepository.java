package br.com.namedida.core.persistence;

import br.com.namedida.domain.*;

import java.util.List;
import java.util.Optional;

public interface UsuarioDepartamentoRepository extends GenericRepository<UsuarioDepartamento> {
    Optional<UsuarioDepartamento> findByEmail(String email);
    List<UsuarioDepartamento> findAllByDepartamento(Departamento departamento);
}
