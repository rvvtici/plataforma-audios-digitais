CREATE TABLE artista (
    id_artista INT PRIMARY KEY NOT NULL,
    nome TEXT NOT NULL
);

CREATE TABLE album (
    id_album INT PRIMARY KEY,
    nome TEXT NOT NULL,
    data DATE NOT NULL,
    capa TEXT NOT NULL,
    genero TEXT NOT NULL,
    id_artista INT NOT NULL,
    FOREIGN KEY (id_artista) REFERENCES artista(id_artista)
);

CREATE TABLE musica (
    id_musica INT PRIMARY KEY NOT NULL,
    nome TEXT NOT NULL,
    duracao TIME NOT NULL,
    id_album INT NOT NULL,
    FOREIGN KEY (id_album) REFERENCES album(id_album)
);

CREATE TABLE usuario (
    usuario TEXT PRIMARY KEY NOT NULL,
    nome TEXT NOT NULL,
    senha TEXT NOT NULL
);

CREATE TABLE playlist (
    id_playlist INT PRIMARY KEY,
    nome TEXT NOT NULL,
    usuario TEXT NOT NULL,
    foto TEXT,
    FOREIGN KEY (usuario) REFERENCES usuario(usuario)
	ON UPDATE CASCADE
	ON DELETE CASCADE

);

INSERT INTO artista (id_artista, nome) 
VALUES 
(001, 'Sleep Token'),
(002, 'Linkin Park');

INSERT INTO album (id_album, nome, data, capa, genero, id_artista)
VALUES 
(001, 'Even In Arcadia', '2025-05-09', 'even-in-arcadia.jpg', 'Rock', 001),
(002, 'LIVING THINGS', '2012-06-19', 'living-this.png', 'Rock', 002);

INSERT INTO musica (id_musica, nome, duracao, id_album)
VALUES 
(101, 'Caramel', '00:04:33', 001),
(102, 'Emergence', '00:06:26', 001),
(201, 'POWERLESS', '00:03:44', 002);

INSERT INTO usuario (usuario, nome, senha)
VALUES 
('ravi', 'ravi', '123');

INSERT INTO playlist (id_playlist, nome, usuario, foto)
VALUES 
(1, 'piiii', 'ravi', 'foto.png');

/* 
select 
	a.nome,
	al.nome
from artista a
inner join album al on a.id_artista = al.id_artista
*/



