package br.com.namedida.domain.form;

import br.com.namedida.domain.UnidadeEnsino;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class UnidadeEnsinoTurmaForm  {
        private String nome;
        private Integer quantidade;
        private LocalDate horarioInicial;
        private LocalDate horarioFinal;
        private String sala;
        private Long unidadeEnsino;
}
