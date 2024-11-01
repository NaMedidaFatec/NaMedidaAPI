package br.com.namedida.core.validator;

import br.com.namedida.core.persistence.RequisicaoItemRepository;
import br.com.namedida.domain.RequisicaoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequisicaoItemValidator {
    private static RequisicaoItemRepository requisicaoItemRepository;

    @Autowired
    public void setRequisicaoItemRepository(RequisicaoItemRepository repository) {
        RequisicaoItemValidator.requisicaoItemRepository = repository;
    }

    public static RequisicaoItem validate(Long id) throws Exception {
        return requisicaoItemRepository.
                findById(id).
                orElseThrow(() -> new Exception("Item do pedido não encontrado"));
    }
}