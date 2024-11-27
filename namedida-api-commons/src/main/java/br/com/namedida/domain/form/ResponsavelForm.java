package br.com.namedida.domain.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsavelForm extends PFForm {
    private String cargo;
    private String setor;
    private String nivelEnsino;

    ResponsavelForm(String nome, String email, TelefoneForm telefoneForm, EnderecoForm enderecoForm) {
        super(nome, email, telefoneForm, enderecoForm);
    }
}
