package br.com.namedida.domain.form;

import br.com.namedida.domain.Usuario;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RequisicaoSeparacaoForm {
        private Long id;
        private String observacoes;
        private LocalDate data;
        private boolean finalizada;
        private Usuario separador;
        private Long requisicao;
}
