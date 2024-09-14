package br.com.namedida.core.persistence;

import br.com.namedida.domain.EntidadeDominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends EntidadeDominio>
    extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}
