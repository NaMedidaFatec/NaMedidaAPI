package br.com.namedida.core.service.security;

import br.com.namedida.core.persistence.UsuarioDepartamentoRepository;
import br.com.namedida.core.persistence.UsuarioUnidadeEnsinoRepository;
import br.com.namedida.core.service.security.util.JwtTokenUtil;
import br.com.namedida.core.validator.CidadeValidator;
import br.com.namedida.core.validator.UnidadeEnsinoValidator;
import br.com.namedida.domain.*;
import br.com.namedida.domain.enums.TipoUsuario;
import br.com.namedida.domain.form.AuthenticationForm;
import br.com.namedida.domain.form.EnderecoForm;
import br.com.namedida.domain.form.TelefoneForm;
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

    public String authenticate(AuthenticationForm authenticationForm) {
        UserAuthenticated userDetail = null;
        if (authenticationForm.getTipoUsuario().equals(TipoUsuario.DEPARTAMENTO)) {
            userDetail = usuarioDepartamentoRepository.findByEmailAndPassword(authenticationForm.getEmail(),  authenticationForm.getPassword())
                    .map(UserAuthenticated::new)
                    .orElseThrow(
                            () -> new UsernameNotFoundException("Usuário do departamento não encontrado com o e-mail: " + authenticationForm.getEmail()));
        } else {
            userDetail = usuarioUnidadeEnsinoRepository.findByEmailAndPassword(authenticationForm.getEmail(),  authenticationForm.getPassword())
                    .map(UserAuthenticated::new)
                    .orElseThrow(
                            () -> new UsernameNotFoundException("Usuário da instituição de ensino não encontrado com o e-mail: " + authenticationForm.getEmail()));
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
                            .password(form.getPassword())
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
                        .password(form.getPassword())
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
