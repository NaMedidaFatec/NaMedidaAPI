package br.com.namedida.domain.form;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class PessoaForm {
    private String nome;
    private String email;
    private TelefoneForm telefoneForm;
    private EnderecoForm enderecoForm;
}
