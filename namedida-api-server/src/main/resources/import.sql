INSERT INTO pais (enabled, created_at, updated_at, nome) VALUES (true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Brasil');


INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Acre', 'AC',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Alagoas', 'AL',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Amapá', 'AP',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Amazonas', 'AM',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Bahia', 'BA',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Ceará', 'CE',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Distrito Federal', 'DF',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Espírito Santo', 'ES',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Goiás', 'GO',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Maranhão', 'MA',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Mato Grosso', 'MT',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Mato Grosso do Sul', 'MS',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Minas Gerais', 'MG',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Pará', 'PA',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Paraíba', 'PB',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Paraná', 'PR',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Pernambuco', 'PE',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Piauí', 'PI',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Rio de Janeiro', 'RJ',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Rio Grande do Norte', 'RN',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Rio Grande do Sul', 'RS',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Rondônia', 'RO',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Roraima', 'RR',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Santa Catarina', 'SC',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'São Paulo', 'SP',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Sergipe', 'SE',1) ;
INSERT INTO estado (enabled, created_at, updated_at, nome, uf , pais_id)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Tocantins', 'TO',1) ;


INSERT INTO cidade (enabled, created_at, updated_at, nome, estado) VALUES (true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'São Paulo', 1) ;


INSERT INTO usuario (enabled, created_at, updated_at, username, password)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'root', 'sliver') ;