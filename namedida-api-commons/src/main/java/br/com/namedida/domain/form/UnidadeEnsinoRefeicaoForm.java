package br.com.namedida.domain.form;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UnidadeEnsinoRefeicaoForm {
        private String nome;
        private String descricao;
        private LocalDateTime horarioDisponibilidade;
        private Long unidadeEnsino;
}
