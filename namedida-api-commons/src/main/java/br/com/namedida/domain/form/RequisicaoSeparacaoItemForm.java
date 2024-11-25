package br.com.namedida.domain.form;

import br.com.namedida.domain.Lote;
import br.com.namedida.domain.RequisicaoSeparacaoItem;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class RequisicaoSeparacaoItemForm {
        private Long id;
        private Double quantidadeEntregue = 0d;
        private Long estoque;
        private Long requisicaoItem;
}

