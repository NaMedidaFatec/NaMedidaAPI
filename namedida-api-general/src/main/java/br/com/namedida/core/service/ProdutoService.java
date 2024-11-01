package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.core.validator.DepartamentoValidator;
import br.com.namedida.domain.Produto;
import br.com.namedida.domain.enums.Categoria;
import br.com.namedida.domain.form.ProdutoForm;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService extends GenericService<Produto> {

    @Autowired
    public ProdutoService(
            GenericRepository<Produto> repository,
            List<IValidation<Produto>> saveValidations,
            List<IValidation<Produto>> updateValidation)
    {
        super();
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
    }

    public ProdutoService() {

    }

    public Result save(ProdutoForm form) throws Exception {
        Produto produto = Produto.produtoBuilder()
                .nome(form.getNome())
                .descricao(form.getDescricao())
                .departamento(DepartamentoValidator.validate(form.getDepartamento()))
                .codigoDeBarras(form.getCodigoDeBarras())
                .build();

        if (Strings.isNotBlank(form.getCategoria())) {
            produto.setCategoria(Categoria.valueOf(form.getCategoria()));
        }

        this.executeRules(this.saveValidations, produto);

        if (!this.result.hasErrors()) {
            this.result.setData(this.repository.save(produto));
        }
        return this.result;
    }
}