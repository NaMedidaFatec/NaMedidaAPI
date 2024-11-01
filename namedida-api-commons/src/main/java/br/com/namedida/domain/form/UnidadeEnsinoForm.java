package br.com.namedida.domain.form;

import br.com.namedida.domain.enums.NivelEnsino;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalTime;

@Data
public class UnidadeEnsinoForm extends PJForm {
        private Long departamento;
        private LocalTime horarioAbertura;
        private LocalTime horarioFechamento;
        private String nivelEnsino;
        private ResponsavelForm responsavelForm;
        UnidadeEnsinoForm(String nome, String email, TelefoneForm telefoneForm, EnderecoForm enderecoForm) {
                super(nome, email, telefoneForm, enderecoForm);
        }
}
