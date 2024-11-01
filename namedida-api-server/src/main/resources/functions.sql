DROP FUNCTION IF EXISTS getRefeicoesUnidade;
DELIMITER $$
CREATE FUNCTION `getRefeicoesUnidade`(`p_unidadeensino` INT(11)) RETURNS int(11)
                                                                                 READS SQL DATA
BEGIN
    DECLARE r_total int;
SELECT count(*) from refeicao r where r.unidadeEnsino_id = p_unidadeensino
    INTO r_total;
RETURN r_total;
END$$
DELIMITER ;

DROP FUNCTION IF EXISTS getQtdAlunosMatriculados;
DELIMITER $$
CREATE FUNCTION `getQtdAlunosMatriculados`(`p_unidadeensino` INT(11)) RETURNS int(11)
                                                                                 READS SQL DATA
BEGIN
    DECLARE r_total int;
SELECT COALESCE(SUM(t.quantidade), 0) from turma t where t.unidadeEnsino_id = p_unidadeensino
    INTO r_total;
RETURN r_total;
END$$
DELIMITER ;


DROP FUNCTION IF EXISTS getQtdItensPendentes;
DELIMITER $$
CREATE FUNCTION `getQtdItensPendentes`(`p_requisicao` INT(11)) RETURNS int(11)
                                                                                 READS SQL DATA
BEGIN
    DECLARE r_total int;
SELECT COALESCE(SUM(i.quantidade - i.quantidadeEntregue), 0) from requisicaoitem i where i.requisicao_id = p_requisicao
    INTO r_total;
RETURN r_total;
END$$
DELIMITER ;

DROP FUNCTION IF EXISTS getEstoque;
DELIMITER $$
CREATE FUNCTION `getEstoque`(`p_produto` INT(11)) RETURNS int(11)
                                                                          READS SQL DATA
BEGIN
    DECLARE r_total int;
SELECT COALESCE(SUM(l.quantidade), 0) from lote l where l.produto_id = p_produto
    INTO r_total;
RETURN r_total;
END$$
DELIMITER ;




