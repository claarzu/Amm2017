--DB db: ammdb, user: ammdb, password: ammdb */ 

CREATE TABLE postType(
	posttype_id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	posttype_name VARCHAR(32)
);


CREATE TABLE iscritti(
    iscritto_id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(256),
    cognome VARCHAR(256),
    urlImmProf VARCHAR(256),
    frase VARCHAR(1024),
    data_iscritto VARCHAR(256),
    username VARCHAR(256) UNIQUE,
    password VARCHAR(256) NOT NULL    
);


CREATE TABLE posts(
    post_id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    content VARCHAR(1024),
    type INTEGER,
    FOREIGN KEY (type) REFERENCES postType(postType_id),
    author INTEGER,
    FOREIGN KEY (author) REFERENCES iscritti(iscritto_id)
);


CREATE TABLE gruppi(
    gruppo_id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(256) UNIQUE,	
    membro INTEGER,
    FOREIGN KEY (membro) REFERENCES iscritti(iscritto_id)
);


CREATE TABLE amici(
    follower INTEGER,
    FOREIGN KEY (follower) REFERENCES iscritti(iscritto_id),
    followed INTEGER,
    FOREIGN KEY (followed) REFERENCES iscritti(iscritto_id),
    PRIMARY KEY (follower, followed)
);


INSERT INTO iscritti (iscritto_id, nome, cognome, urlImmProf, frase, data_iscritto, username, password) 
VALUES (default,
	'Utente',
	'Amm',
	'Immagini/utenti.png',
	'',
	'10/02/4578',
	'userrr',
	'123');


INSERT INTO iscritti (iscritto_id, nome, cognome, urlImmProf, frase, data_iscritto, username, password) 
VALUES (default,
	'Pluto',
	'Disney',
	'Immagini/pt.png',
	'Crocchetta',
	'30/04/1931',
	'cane',
	'222');

INSERT INTO iscritti (iscritto_id, nome, cognome, urlImmProf, frase, data_iscritto, username, password) 
VALUES (default,
	'Topolino',
	'Disney',
	'Immagini/tp.png',
	'kaff�������',
	'18/11/1928',
	'topo',
	'333');

INSERT INTO iscritti (iscritto_id, nome, cognome, urlImmProf, frase, data_iscritto, username, password) 
VALUES (default,
	'Paperino',
	'Disney',
	'Immagini/tp.png',
	'mmmmm... paperina',
	'09/06/1934',
	'papera',
	'111');

INSERT INTO posttype (posttype_id, posttype_name)
VALUES (default, 'TEXT');

INSERT INTO posttype (posttype_id, posttype_name)
VALUES (default, 'IMAGE');


INSERT INTO posts (post_id, content, type, author)
VALUES (default,
        'Il mio primo post',
        1,
        1);


INSERT INTO posts (post_id, content, type, author)
VALUES (default,
        'crocchetta',
        1,
        2);


INSERT INTO posts (post_id, content, type, author)
VALUES (default,
        'Immagini/schedamadre.jpg',
        2,
        3);


INSERT INTO posts (post_id, content, type, author)
VALUES (default,
        'https://unica.it',
        1,
        4);

INSERT INTO amici (follower, followed)
VALUES (1, 2),
       (1, 3),
       (1, 4),
       (2, 1),
       (3, 4);

INSERT INTO amici (follower, followed)
VALUES (3, 1),
       (3, 2);

INSERT INTO amici (follower, followed)
VALUES (4, 2); 