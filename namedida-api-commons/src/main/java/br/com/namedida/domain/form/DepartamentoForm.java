package br.com.namedida.domain.form;

import lombok.Data;

@Data
public class DepartamentoForm extends PJForm {
        private String identificador;

        public DepartamentoForm(String nome, String email, TelefoneForm telefoneForm, EnderecoForm enderecoForm, String identificador) {
                super(nome, email, telefoneForm, enderecoForm);
                this.identificador = identificador;
        }
}
