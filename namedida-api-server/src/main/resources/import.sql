INSERT INTO `pais` (`id`, `created_at`, `enabled`, `updated_at`, `nome`) VALUES
    (1, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Brasil');

INSERT INTO `estado` (`id`, `created_at`, `enabled`, `updated_at`, `nome`, `uf`, `pais_id`) VALUES
                                                                                                (1, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Acre', 'AC', 1),
                                                                                                (2, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Alagoas', 'AL', 1),
                                                                                                (3, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Amapá', 'AP', 1),
                                                                                                (4, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Amazonas', 'AM', 1),
                                                                                                (5, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Bahia', 'BA', 1),
                                                                                                (6, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Ceará', 'CE', 1),
                                                                                                (7, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Distrito Federal', 'DF', 1),
                                                                                                (8, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Espírito Santo', 'ES', 1),
                                                                                                (9, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Goiás', 'GO', 1),
                                                                                                (10, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Maranhão', 'MA', 1),
                                                                                                (11, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Mato Grosso', 'MT', 1),
                                                                                                (12, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Mato Grosso do Sul', 'MS', 1),
                                                                                                (13, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Minas Gerais', 'MG', 1),
                                                                                                (14, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Pará', 'PA', 1),
                                                                                                (15, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Paraíba', 'PB', 1),
                                                                                                (16, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Paraná', 'PR', 1),
                                                                                                (17, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Pernambuco', 'PE', 1),
                                                                                                (18, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Piauí', 'PI', 1),
                                                                                                (19, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Rio de Janeiro', 'RJ', 1),
                                                                                                (20, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Rio Grande do Norte', 'RN', 1),
                                                                                                (21, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Rio Grande do Sul', 'RS', 1),
                                                                                                (22, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Rondônia', 'RO', 1),
                                                                                                (23, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Roraima', 'RR', 1),
                                                                                                (24, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Santa Catarina', 'SC', 1),
                                                                                                (25, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'São Paulo', 'SP', 1),
                                                                                                (26, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Sergipe', 'SE', 1),
                                                                                                (27, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Tocantins', 'TO', 1);

INSERT INTO `cidade` (`id`, `created_at`, `enabled`, `updated_at`, `nome`, `estado`) VALUES
    (3, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'São Paulo', 1),
    (4, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', 'Mogi das Cruzes', 1);

INSERT INTO `endereco` (`id`, `created_at`, `enabled`, `updated_at`, `bairro`, `cep`, `complemento`, `logradouro`, `numero`, `cidade_id`) VALUES
                                                                                                                                              (1, '2024-11-06 23:06:48.927000', b'1', '2024-11-06 23:06:48.927000', 'Jardim Paulista', '01402-000', 'apto 101', 'Rua Professor José Maria Rodrigues', '1234', 3),
                                                                                                                                              (2, '2024-11-06 23:18:48.875000', b'1', '2024-11-06 23:18:48.875000', 'Jardim Paulista', '01402-000', 'apto 101', 'Rua Professor José Maria Rodrigues', '1234', 3),
                                                                                                                                              (3, '2024-11-06 23:19:04.826000', b'1', '2024-11-06 23:19:04.826000', 'Jardim Paulista', '01402-000', 'apto 101', 'Rua Professor José Maria Rodrigues', '1234', 3),
                                                                                                                                              (4, '2024-11-06 23:19:04.837000', b'1', '2024-11-06 23:19:04.837000', 'Jardim Paulista', '01402-000', 'apto 101', 'Rua Professor José Maria Rodrigues', '1234', 3),
                                                                                                                                              (5, '2024-11-06 23:20:42.032000', b'1', '2024-11-06 23:20:42.032000', 'Jardim Paulista', '01402-000', 'apto 101', 'Rua Professor José Maria Rodrigues', '1234', 3);

INSERT INTO `telefone` (`id`, `created_at`, `enabled`, `updated_at`, `ddd`, `numero`) VALUES
                                                                                          (1, '2024-11-06 23:06:48.987000', b'1', '2024-11-06 23:06:48.987000', '11', '46388888'),
                                                                                          (2, '2024-11-06 23:18:48.907000', b'1', '2024-11-06 23:18:48.907000', '11', '46388888'),
                                                                                          (3, '2024-11-06 23:19:04.829000', b'1', '2024-11-06 23:19:04.829000', '11', '46388888'),
                                                                                          (4, '2024-11-06 23:19:04.839000', b'1', '2024-11-06 23:19:04.839000', '11', '46388888'),
                                                                                          (5, '2024-11-06 23:20:42.036000', b'1', '2024-11-06 23:20:42.036000', '11', '46388888');


INSERT INTO `pessoa` (`discriminator`, `id`, `created_at`, `enabled`, `updated_at`, `email`, `nome`, `cnpj`, `razaoSocial`, `tipoPessoa`, `identificador`, `apelido`, `cpf`, `dataNascimento`, `rg`, `cargo`, `escolariade`, `setor`, `horarioAbertura`, `horarioFechamento`, `nivelEnsino`, `endereco_id`, `telefone_id`, `departamento_id`, `responsavel_id`) VALUES
                                                                                                                                                                                                                                                                                                                                                                    ('departamento', 1, '2024-11-06 23:18:48.856000', b'1', '2024-11-06 23:18:48.856000', 'contato@contato.com.br', 'Departamento de Mogi', '12345678901234', 'DAE MOGI.', 'PJ', 'DAE-CESAR.', NULL, NULL, NULL, NULL, NULL, 'SUPERIOR', NULL, NULL, NULL, NULL, 2, 2, NULL, NULL),
                                                                                                                                                                                                                                                                                                                                                                    ('responsavel', 2, '2024-11-06 23:19:04.833000', b'1', '2024-11-06 23:19:04.833000', 'contato@escolafantastica.com.br', 'João Silva', NULL, NULL, 'PF', NULL, 'Jão', '123.456.789-00', '1990-01-15', '12.345.678-9', 'Diretor', 'SUPERIOR', 'Administrativo', NULL, NULL, NULL, 4, 4, NULL, NULL),
                                                                                                                                                                                                                                                                                                                                                                    ('unidadeensino', 3, '2024-11-06 23:19:04.822000', b'1', '2024-11-06 23:19:04.822000', 'contato@escolafantastica.com.br', 'Escola Fantástica', '12.345.678/0001-90', 'Escola Fantástica Ltda.', 'PJ', NULL, NULL, NULL, NULL, NULL, NULL, 'SUPERIOR', NULL, '12:00:00.000000', '20:30:00.000000', 'SUPERIOR', 3, 3, 1, 2);

INSERT INTO `produto` (`id`, `created_at`, `enabled`, `updated_at`, `categoria`, `codigoDeBarras`, `descricao`, `nome`, `departamento_id`) VALUES
                                                                                                                                               (1, '2024-11-06 23:19:30.318000', b'1', '2024-11-06 23:19:30.318000', 'ALIMENTICIOS', '12345678', 'Macarrão espaguete nro. 8', 'Macarrão', 1),
                                                                                                                                               (2, '2024-11-06 23:21:11.078000', b'1', '2024-11-06 23:21:11.078000', 'ALIMENTICIOS', '12345678', 'Macarrão espaguete nro. 8', 'Macarrão', 1);

INSERT INTO `lote` (`id`, `created_at`, `enabled`, `updated_at`, `dataFabricacao`, `dataValidade`, `nome`, `quantidade`, `produto_id`) VALUES
    (1, '2024-11-06 23:21:27.548000', b'1', '2024-11-06 23:21:27.548000', '2024-05-15', '2024-05-15', '001', 1000, 1);

INSERT INTO `refeicao` (`id`, `created_at`, `enabled`, `updated_at`, `descricao`, `horarioDisponibilidade`, `nome`, `unidadeEnsino_id`) VALUES
    (1, '2024-11-06 23:22:42.718000', b'1', '2024-11-06 23:22:42.718000', 'Bolinho Ana Maria e achocolatado', '2024-10-28 12:30:00.000000', 'Café da manhã', 3);

INSERT INTO `usuario` (`discriminator`, `id`, `created_at`, `enabled`, `updated_at`, `cpf`, `dataNascimento`, `email`, `nome`, `password`, `cargo`, `registro`, `setor`, `endereco_id`, `telefone_id`, `departamento_id`, `unidadeEnsino_id`) VALUES
                                                                                                                                                                                                                               ('departamento', 1, '2024-11-06 23:06:48.886000', b'1', '2024-11-06 23:06:48.886000', '123.456.789-00', '1990-01-01', 'usuariodepartamento@email.com', 'Nome do Usuário departamento', '$2a$10$xZOX1gKxhyRJozQjxVJNmOWzQv7CBP2QmaWAc4PFumHM5DkKE0ul2', 'Gerente de contas', '123ABC', NULL, 1, 1, 1, NULL),
                                                                                                                                                                                                                               ('unidadeensino', 2, '2024-11-06 23:20:42.028000', b'1', '2024-11-06 23:20:42.028000', '123.456.789-00', '1990-01-01', 'usuarioescola@email.com', 'Nome do Usuário escola', '$2a$10$xZOX1gKxhyRJozQjxVJNmOWzQv7CBP2QmaWAc4PFumHM5DkKE0ul2', 'Gerente de contas', '123ABC', 'Almoxerifado', 5, 5, NULL, 3);

INSERT INTO `requisicao` (`id`, `created_at`, `enabled`, `updated_at`, `data`, `finalizada`, `observacoes`, `departamento_id`, `solicitante_id`, `unidadeEnsino_id`) VALUES
    (1, '2024-11-06 23:21:42.056000', b'1', '2024-11-06 23:21:42.056000', '2024-11-06', b'0', 'Pedido de suprimentos para festas de halloween', 1, 1, 3);

INSERT INTO `requisicaoitem` (`id`, `created_at`, `enabled`, `updated_at`, `quantidade`, `quantidadeEntregue`, `produto_id`, `requisicao_id`) VALUES
    (1, '2024-11-06 23:21:53.121000', b'1', '2024-11-06 23:21:53.121000', 10, 0, 1, 1);

INSERT INTO `requisicaoseparacao` (`id`, `created_at`, `enabled`, `updated_at`, `data`, `finalizada`, `observacoes`, `requisicao_id`, `separadoPor_id`) VALUES
    (1, '2024-11-06 23:22:08.401000', b'1', '2024-11-06 23:22:08.401000', '2024-11-06', b'0', 'Separação de suprimentos para o pedido', 1, 1);

INSERT INTO `requisicaoseparacaoitem` (`id`, `created_at`, `enabled`, `updated_at`, `quantidadeEntregue`, `estoque_id`, `requisicaoItem_id`) VALUES
    (1, '2024-11-06 23:22:23.086000', b'1', '2024-11-06 23:22:23.086000', 5, 1, 1);

INSERT INTO `turma` (`id`, `created_at`, `enabled`, `updated_at`, `horarioFinal`, `horarioInicial`, `nome`, `quantidade`, `sala`, `unidadeEnsino_id`) VALUES
    (1, '2024-11-06 23:22:50.831000', b'1', '2024-11-06 23:22:50.831000', '2024-10-28', '2024-10-28', '5a Série', 30, '5', 3);

INSERT INTO `notificacao` (`id`, `created_at`, `enabled`, `updated_at`, `horario`, `mensagem`, `visto`, `usuario_id`) VALUES
    (1, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', '2024-11-28 13:06:25.000000', 'notificação teste 1', b'0', 1),
    (2, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', '2024-11-28 13:08:25.000000', 'notificação teste 2', b'0', 1),
    (3, '2024-11-06 23:06:25.000000', b'1', '2024-11-06 23:06:25.000000', '2024-11-28 13:09:25.000000', 'notificação teste 3', b'0', 1);