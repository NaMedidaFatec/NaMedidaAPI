package br.com.namedida.core.business;

import br.com.namedida.domain.Lote;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.math.BigDecimal;

@Component
@RequestScope
public class LoteDadosObrigatorios implements IValidation<Lote> {
    private Result result;

    public LoteDadosObrigatorios() {
        this.result = new Result();
    }

    @Override
    public Result execute(Lote lote) {
        if (lote.getQuantidade() == 0) {
            result.addError(new BusinessError("A quantidade informada é inválida"));
        }


        if (lote.getDataValidade().compareTo(lote.getDataFabricacao()) < 0) {
            result.addError(new BusinessError("A data de fabricação não pode ser posterior à data de vencimento"));
        }

        return this.result;
    }
}
