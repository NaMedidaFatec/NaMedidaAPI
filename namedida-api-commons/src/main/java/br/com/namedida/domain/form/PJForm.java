package br.com.namedida.domain.form;

import br.com.namedida.domain.enums.TipoPessoa;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PJForm extends PessoaForm {
    private String razaoSocial;
    private String cnpj;
    @Builder.Default
    private TipoPessoa tipoPessoa = TipoPessoa.PJ;

    PJForm(String nome, String email, TelefoneForm telefoneForm, EnderecoForm enderecoForm) {
        super(nome, email, telefoneForm, enderecoForm);
    }
}
