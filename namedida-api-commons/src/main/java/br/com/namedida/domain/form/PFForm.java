package br.com.namedida.domain.form;

import br.com.namedida.domain.enums.TipoPessoa;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PFForm extends PessoaForm {
    private String rg;
    private String cpf;
    private String apelido;
    private LocalDate dataNascimento;
    @Builder.Default
    private TipoPessoa tipoPessoa = TipoPessoa.PF;

    PFForm(String nome, String email, TelefoneForm telefoneForm, EnderecoForm enderecoForm) {
        super(nome, email, telefoneForm, enderecoForm);
    }
}
