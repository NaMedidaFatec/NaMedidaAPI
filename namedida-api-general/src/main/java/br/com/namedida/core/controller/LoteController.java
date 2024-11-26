package br.com.namedida.core.controller;

import br.com.namedida.core.business.Result;
import br.com.namedida.core.service.LoteService;
import br.com.namedida.core.service.ProdutoService;
import br.com.namedida.domain.Lote;
import br.com.namedida.domain.dto.ResponseDTO;
import br.com.namedida.domain.form.LoteForm;
import br.com.namedida.domain.form.ProdutoForm;
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
@RequestMapping("/lotes")
public class LoteController extends GenericController<Lote> {
    @Autowired
    private LoteService loteService;

    @Autowired
    public LoteController(LoteService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Result save(@RequestBody LoteForm form) throws Exception {
        return loteService.save(form);
    }

    @PutMapping("/entradaItens/{loteId}/{quantidade}")
    public Result entradaItens(@PathVariable Long loteId, @PathVariable Long quantidade) throws Exception {
        return loteService.entradaEstoque(loteId, quantidade);
    }

    @GetMapping("/livre/produto/{id}")
    public ResponseEntity<ResponseDTO> getLotesWithEstoqueLivreByProduto(@PathVariable Long id) throws Exception {
        return this.generateResponse(loteService.getLotesWithEstoqueLivreByProduto(id), HttpStatus.OK);
    }
}
