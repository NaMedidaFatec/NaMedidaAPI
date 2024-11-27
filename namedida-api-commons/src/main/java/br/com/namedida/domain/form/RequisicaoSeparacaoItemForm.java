package br.com.namedida.domain.form;

import lombok.Data;

@Data
public class RequisicaoSeparacaoItemForm {
        private Long id;
        private Double quantidadeEntregue = 0d;
        private Long estoque;
        private Long requisicaoItem;
}

