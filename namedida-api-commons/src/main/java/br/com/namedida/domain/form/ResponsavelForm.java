package br.com.namedida.domain.form;

import br.com.namedida.domain.enums.NivelEnsino;
import br.com.namedida.domain.enums.TipoUsuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

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
