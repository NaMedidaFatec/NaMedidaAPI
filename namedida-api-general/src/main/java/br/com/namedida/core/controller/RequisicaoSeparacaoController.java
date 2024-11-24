package br.com.namedida.core.controller;

import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.RequisicaoSeparacaoService;
import br.com.namedida.domain.RequisicaoSeparacao;
import br.com.namedida.domain.dto.ResponseDTO;
import br.com.namedida.domain.form.RequisicaoSeparacaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/requisicaoseparacao")
public class RequisicaoSeparacaoController extends GenericController<RequisicaoSeparacao> {
    @Autowired
    private RequisicaoSeparacaoService requisicaoService;

    @Autowired
    public RequisicaoSeparacaoController(RequisicaoSeparacaoService service) {
        this.service = service;
    }

    @GetMapping("/requisicao/{id}")
    public ResponseEntity<ResponseDTO> getByRequisicao(@PathVariable Long id) throws Exception {
        return this.generateResponse(requisicaoService.getByRequisicao(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public Result save(
            @RequestBody RequisicaoSeparacaoForm form) throws Exception {
        return requisicaoService.save(form);
    }
}
