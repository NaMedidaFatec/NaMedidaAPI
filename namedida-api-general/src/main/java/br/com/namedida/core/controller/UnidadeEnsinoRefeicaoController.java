package br.com.namedida.core.controller;

import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.UnidadeEnsinoRefeicaoService;
import br.com.namedida.domain.UnidadeEnsinoRefeicao;
import br.com.namedida.domain.form.UnidadeEnsinoRefeicaoForm;
import br.com.namedida.domain.form.UnidadeEnsinoTurmaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/unidadeensinorefeicao")
public class UnidadeEnsinoRefeicaoController extends GenericController<UnidadeEnsinoRefeicao> {
    @Autowired
    private UnidadeEnsinoRefeicaoService unidadeEnsinoRefeicaoService;
    
    @Autowired
    public UnidadeEnsinoRefeicaoController(UnidadeEnsinoRefeicaoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Result save(
            @RequestBody UnidadeEnsinoRefeicaoForm form) throws Exception {
        return unidadeEnsinoRefeicaoService.save(form);
    }
}
