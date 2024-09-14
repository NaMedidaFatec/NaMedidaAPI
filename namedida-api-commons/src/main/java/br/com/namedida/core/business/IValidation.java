package br.com.namedida.core.business;


import br.com.namedida.domain.EntidadeDominio;

public interface IValidation<T extends EntidadeDominio> extends IRule<T> {}
