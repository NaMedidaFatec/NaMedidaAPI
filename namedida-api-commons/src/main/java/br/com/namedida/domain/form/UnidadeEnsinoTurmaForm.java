package br.com.namedida.domain.form;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UnidadeEnsinoTurmaForm  {
        private String nome;
        private Integer quantidade;
        private LocalDate horarioInicial;
        private LocalDate horarioFinal;
        private String sala;
        private Long unidadeEnsino;
}
