package br.com.namedida.core.business;

import br.com.namedida.domain.EntidadeDominio;
import org.springframework.stereotype.Component;

@Component
public interface IRule<T extends EntidadeDominio> {
    Result execute(T entity);
}
