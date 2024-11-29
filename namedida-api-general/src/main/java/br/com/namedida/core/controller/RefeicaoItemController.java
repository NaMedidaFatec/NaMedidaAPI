package br.com.namedida.core.controller;

import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.RefeicaoItemService;
import br.com.namedida.domain.RequisicaoItem;
import br.com.namedida.domain.dto.ResponseDTO;
import br.com.namedida.domain.form.RequisicaoItemForm;
import br.com.namedida.domain.form.UnidadeEnsinoRefeicaoItemForm;
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
@RequestMapping("/refeicaoitem")
public class RefeicaoItemController extends GenericController<RequisicaoItem> {
    @Autowired
    private RefeicaoItemService refeicaoService;

    @Autowired
    public RefeicaoItemController(RefeicaoItemService service) {
        this.service = service;
    }

    @GetMapping("/refeicao/{id}")
    public ResponseEntity<ResponseDTO> getItens(@PathVariable Long id) throws Exception {
        return this.generateResponse(refeicaoService.getItens(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public Result save(
            @RequestBody UnidadeEnsinoRefeicaoItemForm form) throws Exception {
        return refeicaoService.save(form);
    }
}
