package br.com.namedida.core.validator;

import br.com.namedida.core.persistence.RequisicaoRepository;
import br.com.namedida.domain.Requisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequisicaoValidator {
    private static RequisicaoRepository requisicaoRepository;

    @Autowired
    public void setRequisicaoRepository(RequisicaoRepository repository) {
        RequisicaoValidator.requisicaoRepository = repository;
    }

    public static Requisicao validate(Long id) throws Exception {
        return requisicaoRepository.
                findById(id).
                orElseThrow(() -> new Exception("Pedido não encontrado"));
    }
}