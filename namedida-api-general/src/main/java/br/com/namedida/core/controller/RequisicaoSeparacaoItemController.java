package br.com.namedida.core.controller;

import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.RequisicaoSeparacaoItemService;
import br.com.namedida.domain.RequisicaoSeparacaoItem;
import br.com.namedida.domain.dto.ResponseDTO;
import br.com.namedida.domain.form.RequisicaoSeparacaoItemForm;
import jakarta.validation.Valid;
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
@RequestMapping("/requisicaoseparacaoitem")
public class RequisicaoSeparacaoItemController extends GenericController<RequisicaoSeparacaoItem> {
    @Autowired
    private RequisicaoSeparacaoItemService requisicaoService;

    @Autowired
    public RequisicaoSeparacaoItemController(RequisicaoSeparacaoItemService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Result save(
            @RequestBody RequisicaoSeparacaoItemForm form) throws Exception {
        return requisicaoService.save(form);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable Long id, @Valid @RequestBody RequisicaoSeparacaoItem entity) {
        return this.generateResponse(requisicaoService.updateItem(entity, id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Long id) {
        return this.generateResponse(requisicaoService.deleteItem(id), HttpStatus.OK);
    }

    @GetMapping("/requisicaoitem/{id}")
    public ResponseEntity<ResponseDTO> getSeparacoesItem(@PathVariable Long id) throws Exception {
        return this.generateResponse(requisicaoService.getSeparacoesItem(id), HttpStatus.OK);
    }
}
