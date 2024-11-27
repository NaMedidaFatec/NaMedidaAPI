package br.com.namedida.core.persistence;

import br.com.namedida.domain.EntidadeDominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface GenericRepository<T extends EntidadeDominio>
    extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
    Optional<List<T>> findAllByEnabled(boolean enabled);
}
