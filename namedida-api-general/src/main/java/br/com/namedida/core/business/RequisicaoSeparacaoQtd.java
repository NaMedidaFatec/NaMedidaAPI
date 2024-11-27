package br.com.namedida.core.business;

import br.com.namedida.domain.RequisicaoSeparacaoItem;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class RequisicaoSeparacaoQtd implements IValidation<RequisicaoSeparacaoItem> {
    private Result result;

    public RequisicaoSeparacaoQtd() {
        this.result = new Result();
    }

    @Override
    public Result execute(RequisicaoSeparacaoItem requisicaoSeparacaoItem) {
        if (requisicaoSeparacaoItem.getQuantidadeEntregue() == 0) {
            result.addError(new BusinessError("A quantidade informada é inválida"));
        }

        Double quantidadePendente = requisicaoSeparacaoItem.getId() != null ? requisicaoSeparacaoItem.getRequisicaoItem().getQuantidadePendente() + requisicaoSeparacaoItem.getQuantidadeAprovada() : requisicaoSeparacaoItem.getRequisicaoItem().getQuantidadePendente();

        if (requisicaoSeparacaoItem.getQuantidadeEntregue() > quantidadePendente) {
            result.addError(new BusinessError("A quantidade separada não pode exceder a quantidade pendente"));
        }

        if (requisicaoSeparacaoItem.getQuantidadeEntregue() > requisicaoSeparacaoItem.getEstoque().getQuantidade()) {
            result.addError(new BusinessError("A quantidade separada não pode exceder a quantidade disponível em estoque"));
        }

        return this.result;
    }
}
