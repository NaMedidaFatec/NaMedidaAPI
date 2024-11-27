package br.com.namedida.domain.form;

import br.com.namedida.domain.enums.TipoUsuario;
import br.com.namedida.domain.security.PasswordUtil;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;


@Data
public class AuthenticationForm {
    private String username;
    private String password;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String cargo;
    private String registro;
    private String setor;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
    private EnderecoForm enderecoForm;
    private TelefoneForm telefoneForm;
    private Long unidadeEnsino;

    @Getter(AccessLevel.NONE)
    private String passwordEncrypted;
    public String getPasswordEncrypted() {
        return PasswordUtil.encrypt(password);
    }
}
