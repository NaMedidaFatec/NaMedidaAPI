package br.com.namedida.domain.form;

import br.com.namedida.domain.Produto;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LoteForm {
        private String nome;
        private LocalDate dataFabricacao;
        private LocalDate dataValidade;
        private Double quantidade;
        private Long produto;
}
