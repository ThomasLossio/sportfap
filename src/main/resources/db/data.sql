/* 
 * Obs.: password '123190540' = $2a$10$5R/vxO9U5x.UW5WLZIDoFu0RnD9PfSY64j486PaULXq.oUeRbXuTm
 */
INSERT INTO sportfap.JOGADOR(name, numero, semestre, time)
    VALUES ('Ismael', '14','6}', 'piratas');

INSERT INTO sportfap.jogador_profile(TYPE) VALUES ('ROLE_ADMIN');
INSERT INTO sportfap.jogador_profile(TYPE) VALUES ('ROLE_USER');

INSERT INTO sportfap.authority (jogador_id, jogador_profile_id) VALUES (2, 1);-- admin
INSERT INTO sportfap.authority (jogador_id, jogador_profile_id) VALUES (1, 2);-- pablo