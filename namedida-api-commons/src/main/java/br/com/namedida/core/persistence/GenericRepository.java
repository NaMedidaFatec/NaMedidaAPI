package br.com.namedida.core.persistence;

import br.com.namedida.domain.EntidadeDominio;
import br.com.namedida.domain.UsuarioDepartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface GenericRepository<T extends EntidadeDominio>
    extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
    Optional<T> findAllByEnabled(boolean enabled);
}
