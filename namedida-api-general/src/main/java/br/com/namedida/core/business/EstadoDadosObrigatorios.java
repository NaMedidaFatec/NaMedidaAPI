package br.com.namedida.core.business;

import br.com.namedida.domain.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class EstadoDadosObrigatorios implements IValidation<Estado> {

    private Result result;

    public EstadoDadosObrigatorios() {
        this.result = new Result();
    }

    @Override
    public Result execute(Estado estado) {
        if(estado.getNome() == null  || estado.getNome().equals("")) {
            result.addError(new BusinessError("O campo nome é obrigatório."));
        }

        return this.result;
    }
}
