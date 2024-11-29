package br.com.namedida.domain.form;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class UnidadeEnsinoRefeicaoForm {
        private String nome;
        private String descricao;
        private LocalTime horarioDisponibilidade;
        private Long unidadeEnsino;
}
