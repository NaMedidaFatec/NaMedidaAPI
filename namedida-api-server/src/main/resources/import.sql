INSERT INTO pais (enabled, created_at, updated_at, nome) VALUES (true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'Brasil');
INSERT INTO estado (enabled, created_at, updated_at, nome, uf, pais_id) VALUES (true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'São Paulo', 'SP', 1);
INSERT INTO cidade (enabled, created_at, updated_at, nome, estado) VALUES (true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'São Paulo', 1) ;


INSERT INTO usuario (enabled, created_at, updated_at, username, password)VALUES(true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),'root', 'sliver') ;