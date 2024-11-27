package br.com.namedida.core.service.security;

import br.com.namedida.core.persistence.UsuarioDepartamentoRepository;
import br.com.namedida.core.persistence.UsuarioUnidadeEnsinoRepository;
import br.com.namedida.core.service.security.bean.StakeholdersBean;
import br.com.namedida.core.service.security.util.JwtTokenUtil;
import br.com.namedida.core.validator.CidadeValidator;
import br.com.namedida.core.validator.UnidadeEnsinoValidator;
import br.com.namedida.domain.*;
import br.com.namedida.domain.enums.TipoUsuario;
import br.com.namedida.domain.form.AuthenticationForm;
import br.com.namedida.domain.form.EnderecoForm;
import br.com.namedida.domain.form.TelefoneForm;
import br.com.namedida.domain.security.PasswordUtil;
import br.com.namedida.domain.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtTokenUtil tokenUtil;
    private final UsuarioDepartamentoRepository usuarioDepartamentoRepository;
    private final UsuarioUnidadeEnsinoRepository  usuarioUnidadeEnsinoRepository;
    private final StakeholdersBean stakeholdersBean;


    public String authenticate(AuthenticationForm authenticationForm) {
        UserAuthenticated userDetail = null;
        if (authenticationForm.getTipoUsuario().equals(TipoUsuario.DEPARTAMENTO)) {
            userDetail = usuarioDepartamentoRepository.findByEmail(authenticationForm.getEmail())
                    .map(UserAuthenticated::new)
                    .orElseThrow(
                            () -> new UsernameNotFoundException("Usuário do departamento não encontrado com o e-mail: " + authenticationForm.getEmail()));
        } else {
            userDetail = usuarioUnidadeEnsinoRepository.findByEmail(authenticationForm.getEmail())
                    .map(UserAuthenticated::new)
                    .orElseThrow(
                            () -> new UsernameNotFoundException("Usuário da instituição de ensino não encontrado com o e-mail: " + authenticationForm.getEmail()));
        }

        if (!PasswordUtil.verify(authenticationForm.getPassword(), userDetail.getUser().getPassword())) {
            throw new UsernameNotFoundException("Senha inválida");
        }

        if (!userDetail.getUser().getEnabled()) {
            throw new UsernameNotFoundException("Usuário inativo");
        }

        if (userDetail.getUserUnidadeEnsino() != null) {
            if (!userDetail.getUserUnidadeEnsino().getUnidadeEnsino().getEnabled()) {
                throw new UsernameNotFoundException("Escola inativa");
            }
        }

        return tokenUtil.generateJwtToken(userDetail);
    }

    public Usuario signup(AuthenticationForm form) throws Exception {
        EnderecoForm enderecoForm = form.getEnderecoForm();
        Endereco endereco = Endereco.enderecoBuilder()
                .numero(enderecoForm.getNumero())
                .logradouro(enderecoForm.getLogradouro())
                .complemento(enderecoForm.getComplemento())
                .bairro(enderecoForm.getBairro())
                .cep(enderecoForm.getCep())
                .cidade(CidadeValidator.validate(enderecoForm.getCidade()))
                .build();

        TelefoneForm telefoneForm = form.getTelefoneForm();
        Telefone telefone = Telefone.telefoneBuilder()
                .numero(telefoneForm.getNumero())
                .ddd(telefoneForm.getDdd())
                .build();

        if (form.getTipoUsuario().equals(TipoUsuario.DEPARTAMENTO) ) {
            UsuarioDepartamento usuarioDepartamento = UsuarioDepartamento.usuarioDepartamentoBuilder()
                            .nome(form.getNome())
                            .cpf(form.getCpf())
                            .dataNascimento(form.getDataNascimento())
                            .email(form.getEmail())
                            .username(form.getUsername())
                            .password(form.getPasswordEncrypted())
                            .cargo(form.getCargo())
                            .registro(form.getRegistro())
                            .endereco(endereco)
                            .telefone(telefone)
                            .build();
            usuarioDepartamento = usuarioDepartamentoRepository.save(usuarioDepartamento);
            return usuarioDepartamento;
        }
        UsuarioUnidadeEnsino usuarioUnidadeEnsino = UsuarioUnidadeEnsino.usuarioUnidadeEnsino()
                        .nome(form.getNome())
                        .cpf(form.getCpf())
                        .dataNascimento(form.getDataNascimento())
                        .unidadeEnsino(UnidadeEnsinoValidator.validate(form.getUnidadeEnsino()))
                        .email(form.getEmail())
                        .username(form.getUsername())
                        .password(form.getPasswordEncrypted())
                        .setor(form.getSetor())
                        .cargo(form.getCargo())
                        .registro(form.getRegistro())
                        .telefone(telefone)
                        .endereco(endereco)
                        .build();

        usuarioUnidadeEnsino = usuarioUnidadeEnsinoRepository.save(usuarioUnidadeEnsino);
        return usuarioUnidadeEnsino;
    }
}
