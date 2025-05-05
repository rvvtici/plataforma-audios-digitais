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

CREATE TABLE liked_songs (
	usuario TEXT NOT NULL,
	id_musica INT NOT NULL,
	FOREIGN KEY (usuario) REFERENCES usuario(usuario)
		ON UPDATE CASCADE
		ON DELETE CASCADE,
	FOREIGN KEY (id_musica) REFERENCES musica(id_musica)
);


INSERT INTO artista (id_artista, nome) 
VALUES 
(001, 'Sleep Token'),
(002, 'Linkin Park'),
(003, 'NewJeans'),
(004, 'Bo Burnham'),
(005, 'Tuyo'),
(006, 'Bad Omens'),
(007, 'Poppy'),
(008, 'Bring Me The Horizon'),
(009, 'Twenty One Pilots'),
(010, 'Kendrick Lamar'),
(011, 'Tyler, The Creator'),
(012, 'Metro Boomin'),
(13, 'Gorillaz');

INSERT INTO album (id_album, nome, data, capa, genero, id_artista)
VALUES 
(001, 'Even In Arcadia', '2025-05-09', 'even-in-arcadia.jpg', 'Rock', 001),
(002, 'LIVING THINGS', '2012-06-19', 'living-this.png', 'Rock', 002),
(003, 'Ditto', '2022-12-19', 'ditto.jpg', 'K-Pop', 003),
(004, 'INSIDE', '2021-06-10', 'inside.jpg', 'Pop', 004),
(005, 'Terminal', '2021-04-12', 'terminal.jpg', 'Indie', 005),
(006, 'V.A.N.', '2024-01-24', 'van.png', 'Alternative Metal', 006),
(007, 'I Disagree', '2020-01-09', 'i-disagree-poppy.jpg', 'Metal', 007),
(008, 'Music to listen to~dance to~blaze to~pray to~feed to~sleep to~talk to~grind to~trip to~breathe to~help to~hurt to~scroll to~roll to~love to~hate to~learn Too~plot to~play to~be to~feel to~breed to~sweat to~dream to~hide to~live to~die to~GO TO', '2019-12-27', 'music-to-listen.jpg', 'Rock', 008),
(009, 'Clancy', '2024-12-24', 'clancy.png', 'Alternative', 009),
(010, 'Twenty One Pilots', '2009-12-29', 'self-titled-twenty-one-pilots.jpg', 'Indie', 009),
(011, 'GNX', '2024-11-22', 'gnx.jpg', 'Hip-hop', 010),
(012, 'CHROMAKOPIA', '2024-10-28', 'chromakopia.jpg', 'Hip-hop', 011),
(013, 'METRO BOOMIN PRESENTS SPIDER-MAN: ACROSS THE SPIDER-VERSE (SOUNDRTRACK FROM AND INSPIRED BY THE MOTION PICTURE)', '2023-06-02', 'spiderverse.jpg', 'Alternative hip-hop', 012),
(014, 'Cracker Island', '2023-02-24', 'cracker-island.png', 'Alternative Rock', 13);


INSERT INTO musica (id_musica, nome, duracao, id_album)
VALUES 
(1, 'Caramel', '00:04:33', 001),
(2, 'Emergence', '00:06:26', 001),
(3, 'POWERLESS', '00:03:44', 002),
(4,  'Ditto', '00:03:05', 003),
(5,  'Goodbye', '00:04:20', 004),
(6,  'Terminal', '00:04:10', 005),
(7,  'V.A.N.', '00:03:58', 006),
(8,  'Don''t Go Outside', '00:05:12', 007),
(9,  'Like Seeing Spiders Running Riot On Your Lover’s Grave', '00:05:40', 008),
(10, 'Vignette', '00:04:00', 009),
(11, 'A Car, A Torch, A Death', '00:04:33', 010),
(12, 'Luther', '00:03:29', 011),
(13, 'Like Him', '00:03:20', 012),
(14, 'Annihilate', '00:03:50', 013),
(15, 'Possession Island', '00:03:20', 014);





INSERT INTO usuario (usuario, nome, senha)
VALUES 
('ravi', 'ravi', '123');

INSERT INTO playlist (id_playlist, nome, usuario, foto)
VALUES 
(1, 'piiii', 'ravi', 'foto.png');






/*
select m.nome as nome_musica, al.nome as nome_album, art.nome as nome_arista, m.duracao
                     from musica m
                     inner join album al on al.id_album = m.id_album
                     inner join artista art on art.id_artista = al.id_artista
*/


/*
DROP TABLE IF EXISTS playlist, musica, album, usuario, artista, liked_songs CASCADE;
*/



