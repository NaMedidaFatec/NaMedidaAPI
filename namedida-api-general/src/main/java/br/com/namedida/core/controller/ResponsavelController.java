package br.com.namedida.core.controller;

import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.ResponsavelService;
import br.com.namedida.domain.Responsavel;
import br.com.namedida.domain.form.UnidadeEnsinoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/responsavel")
public class ResponsavelController extends GenericController<Responsavel> {
    @Autowired
    private ResponsavelService responsavelService;

    @Autowired
    public ResponsavelController(ResponsavelService responsavelService) {
        this.responsavelService = responsavelService;
    }

    @PostMapping("/save/{nomeResponsavel}")
    public Result save(
            @RequestParam String nomeResponsavel) throws Exception {
        return responsavelService.save(nomeResponsavel);
    }
}
