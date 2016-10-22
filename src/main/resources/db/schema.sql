-- DROP SCHEMA todahora;
CREATE SCHEMA sportfap AUTHORIZATION ibf321;
  
-- Jogador
CREATE TABLE sportfap.JOGADOR (
	ID serial,
	NAME VARCHAR(80) NOT NULL,
	NUMERO VARCHAR(3),
	SEMESTRE VARCHAR(50) NOT NULL,
	CURSO VARCHAR(90) NOT NULL,
	PRIMARY KEY (id)
); 
COMMENT ON TABLE sportfap.JOGADOR IS 'Responsible for maintaining the record of jogador';
COMMENT ON COLUMN sportfap.JOGADOR.ID IS 'Identifier Jogador';
COMMENT ON COLUMN sportfap.JOGADOR.NAME IS 'Name jogador'; 
COMMENT ON COLUMN sportfap.JOGADOR.NUMERO IS 'Numero jogador';
COMMENT ON COLUMN sportfap.JOGADOR.SEMESTRE IS 'Semestre';
COMMENT ON COLUMN sportfap.JOGADOR.CURSO 'Curso';
CREATE UNIQUE INDEX u_idx_nome ON sportfap.JOGADOR (NOME);

-- Jogador profile
CREATE TABLE sportfap.JOGADOR_PROFILE(
   ID serial,
   TYPE VARCHAR(30) NOT NULL,
   PRIMARY KEY (ID)
);
COMMENT ON TABLE sportfap.JOGADOR_PROFILE IS 'Responsible for maintaining the records of access profiles';
COMMENT ON COLUMN sportfap.JOGADOR_PROFILE.ID IS 'Identifier profile';
COMMENT ON COLUMN sportfap.JOGADOR_PROFILE.TYPE IS 'Type of profile';


-- Authority
CREATE TABLE sportfap.authority (
    JOGADOR_ID bigint NOT NULL,
    JOGADOR_PROFILE_ID bigint NOT NULL,
    PRIMARY KEY (JOGADOR_ID, JOGADOR_PROFILE_ID),
    CONSTRAINT fk_Jjogador_id FOREIGN KEY (JOGADOR_ID) REFERENCES sportfap.JOGADOR (ID),
    CONSTRAINT fk_jogador_profile_id FOREIGN KEY (JOGADOR_PROFILE_ID) REFERENCES SPORTFAP.JOGADOR_PROFILE (ID)
);
COMMENT ON TABLE sportfap.AUTHORITY IS 'Responsible for maintaining the register of permission access';
COMMENT ON COLUMN sportfap.AUTHORITY.JOGADOR_ID IS 'Identifier jogador';
COMMENT ON COLUMN sportfap.AUTHORITY.JOGADOR_PROFILE_ID IS 'Identifier profile';

-- Event
CREATE TABLE sportfap.EVENTO (
	ID serial, 
	NAME VARCHAR(100) NOT NULL, 
	PRIMARY KEY (ID)
);
COMMENT ON TABLE sportfap.EVENT IS 'Responsible for maintaining the record of events';
COMMENT ON COLUMN sportfap.EVENT.ID IS 'Event identifier';
COMMENT ON COLUMN sportfap.EVENT.DESCRIPTION IS 'Description of the event';
COMMENT ON COLUMN sportfap.EVENT.PHOTO_URL IS 'Event photo';
COMMENT ON COLUMN sportfap.EVENT.START_TIME IS 'Start date and time of the event';
COMMENT ON COLUMN sportfap.EVENT.FINISH_TIME IS 'Date and end time of the event';

