package br.com.namedida.domain.form;

import lombok.*;


@Data
public class RequisicaoItemForm {
        private Long id;
        private Double quantidade;
        private Double quantidadeEntregue = 0d;
        private Long produto;
        private Long requisicao;
}
