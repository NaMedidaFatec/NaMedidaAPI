package br.com.namedida.domain.form;

import lombok.Data;

@Data
public class UnidadeEnsinoRefeicaoItemForm {
        private Long id;
        private Double quantidade;
        private Long produto;
        private Long refeicao;
}
