package br.com.namedida.core.controller;

import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.ProdutoService;
import br.com.namedida.core.service.UnidadeEnsinoRefeicaoService;
import br.com.namedida.domain.Produto;
import br.com.namedida.domain.form.ProdutoForm;
import br.com.namedida.domain.form.UnidadeEnsinoTurmaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/produtos")
public class ProdutoController extends GenericController<Produto> {
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Result save(
            @RequestBody ProdutoForm form) throws Exception {
        return produtoService.save(form);
    }
}
