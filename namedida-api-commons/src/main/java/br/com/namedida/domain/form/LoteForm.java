package br.com.namedida.domain.form;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LoteForm {
        private String nome;
        private LocalDate dataFabricacao;
        private LocalDate dataValidade;
        private Double quantidade;
        private Double valorUnitario;
        private Long produto;
}
