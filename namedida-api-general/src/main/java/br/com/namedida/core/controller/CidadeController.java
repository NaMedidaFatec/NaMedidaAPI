package br.com.namedida.core.controller;

import br.com.namedida.core.service.CidadeService;
import br.com.namedida.domain.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/cidades")
public class CidadeController extends GenericController<Cidade> {
    @Autowired
    public CidadeController(CidadeService service) {
        this.service = service;
    }
}
