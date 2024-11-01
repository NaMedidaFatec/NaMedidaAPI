package br.com.namedida.domain.form;

import br.com.namedida.domain.Endereco;
import br.com.namedida.domain.Telefone;
import br.com.namedida.domain.enums.TipoPessoa;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
