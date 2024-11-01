package br.com.namedida.domain.form;

import br.com.namedida.domain.RequisicaoSeparacaoItem;
import lombok.Data;


@Data
public class RequisicaoSeparacaoItemForm {
        private Long id;
        private Double quantidade;
        private Double quantidadeEntregue = 0d;
        private Long lote;
        private Long requisicaoItem;
}

