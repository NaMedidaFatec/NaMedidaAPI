package br.com.namedida.core.validator;

import br.com.namedida.core.persistence.ProdutoRepository;
import br.com.namedida.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoValidator {
    private static ProdutoRepository produtoRepository;

    @Autowired
    public void setProdutoRepository(ProdutoRepository repository) {
        ProdutoValidator.produtoRepository = repository;
    }

    public static Produto validate(Long id) throws Exception {
        return produtoRepository.
                findById(id).
                orElseThrow(() -> new Exception("Produto não encontrado"));
    }
}