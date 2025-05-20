CREATE TABLE artista (
    id_artista SERIAL PRIMARY KEY NOT NULL,
    nome TEXT NOT NULL
);

CREATE TABLE album (
    id_album SERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
    data DATE NOT NULL,
    capa TEXT NOT NULL,
    genero TEXT NOT NULL,
    id_artista INT NOT NULL,
    FOREIGN KEY (id_artista) REFERENCES artista(id_artista)
);

CREATE TABLE musica (
    id_musica SERIAL PRIMARY KEY NOT NULL,
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
    id_playlist SERIAL PRIMARY KEY,	
    nome TEXT NOT NULL,
    descricao TEXT NOT NULL,
    usuario TEXT NOT NULL,
    FOREIGN KEY (usuario) REFERENCES usuario(usuario)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT unique_playlist_por_usuario UNIQUE (nome, usuario)
);

CREATE TABLE playlist_songs (
	id_playlist INT NOT NULL,
        id_musica INT NOT NULL,
	FOREIGN KEY (id_playlist) REFERENCES playlist(id_playlist)
		ON UPDATE CASCADE
		ON DELETE CASCADE,
	FOREIGN KEY (id_musica) REFERENCES musica(id_musica)
);


CREATE TABLE liked_songs (
	usuario TEXT NOT NULL,
	id_musica INT NOT NULL,
	FOREIGN KEY (usuario) REFERENCES usuario(usuario)
		ON UPDATE CASCADE
		ON DELETE CASCADE,
	FOREIGN KEY (id_musica) REFERENCES musica(id_musica)
);

CREATE TABLE unliked_songs (
	usuario TEXT NOT NULL,
	id_musica INT NOT NULL,
	FOREIGN KEY (usuario) REFERENCES usuario(usuario)
		ON UPDATE CASCADE
		ON DELETE CASCADE,
	FOREIGN KEY (id_musica) REFERENCES musica(id_musica)
);


CREATE TABLE historico (
	usuario TEXT NOT NULL,
	search TEXT NOT NULL,
	filtro TEXT NOT NULL,
	data TIMESTAMP NOT NULL,
	FOREIGN KEY (usuario) REFERENCES usuario(usuario)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

INSERT INTO artista (nome) 
VALUES 
('Sleep Token'),
('Linkin Park'),
('NewJeans'),
('Bo Burnham'),
('Tuyo'),
('Bad Omens'),
('Poppy'),
('Bring Me The Horizon'),
('Twenty One Pilots'),
('Kendrick Lamar'),
('Tyler, The Creator'),
('Metro Boomin'),
('Gorillaz'),
('My Chemical Romance');

INSERT INTO album (nome, data, capa, genero, id_artista)
VALUES 
('Even In Arcadia', '2025-05-09', 'even-in-arcadia.jpg', 'Rock', 001),
('LIVING THINGS', '2012-06-19', 'living-this.png', 'Rock', 002),
('Ditto', '2022-12-19', 'ditto.jpg', 'K-Pop', 003),
('INSIDE', '2021-06-10', 'inside.jpg', 'Pop', 004),
('Terminal', '2021-04-12', 'terminal.jpg', 'Indie', 005),
('V.A.N.', '2024-01-24', 'van.png', 'Alternative Metal', 006),
('I Disagree', '2020-01-09', 'i-disagree-poppy.jpg', 'Metal', 007),
('Music to listen to~dance to~blaze to~pray to~feed to~sleep to~talk to~grind to~trip to~breathe to~help to~hurt to~scroll to~roll to~love to~hate to~learn Too~plot to~play to~be to~feel to~breed to~sweat to~dream to~hide to~live to~die to~GO TO', '2019-12-27', 'music-to-listen.jpg', 'Rock', 008),
('Clancy', '2024-12-24', 'clancy.png', 'Alternative', 009),
('Twenty One Pilots', '2009-12-29', 'self-titled-twenty-one-pilots.jpg', 'Indie', 009),
('GNX', '2024-11-22', 'gnx.jpg', 'Hip-hop', 010),
('CHROMAKOPIA', '2024-10-28', 'chromakopia.jpg', 'Hip-hop', 011),
('METRO BOOMIN PRESENTS SPIDER-MAN: ACROSS THE SPIDER-VERSE (SOUNDRTRACK FROM AND INSPIRED BY THE MOTION PICTURE)', '2023-06-02', 'spiderverse.jpg', 'Alternative hip-hop', 012),
('Cracker Island', '2023-02-24', 'cracker-island.png', 'Alternative Rock', 13),
('The Black Parade', '2006-10-20', 'black-parade.png', 'Rock', 14),
('Three Cheers for Sweet Revenge', '2008-06-08', 'three-cheers.png', 'Rock', 14);


INSERT INTO musica (nome, duracao, id_album)
VALUES 
('Caramel', '00:04:33', 001),
('Emergence', '00:06:26', 001),
('POWERLESS', '00:03:44', 002),
('Ditto', '00:03:05', 003),
('Goodbye', '00:04:20', 004),
('Terminal', '00:04:10', 005),
('V.A.N.', '00:03:58', 006),
('Don''t Go Outside', '00:05:12', 007),
('Like Seeing Spiders Running Riot On Your Lover’s Grave', '00:05:40', 008),
('Vignette', '00:04:00', 009),
('A Car, A Torch, A Death', '00:04:33', 010),
('Luther', '00:03:29', 011),
('Like Him', '00:03:20', 012),
('Annihilate', '00:03:50', 013),
('Possession Island', '00:03:20', 014),
('Famous Last Words', '00:04:59', 015),
('I Don''t Love You', '00:03:58', 015),
('I''m Not Okay (I Promise)', '00:03:06', 016);



INSERT INTO usuario (usuario, nome, senha)
VALUES 
('ravi', 'ravi', '123'),
('a', 'a', 'a');


INSERT INTO liked_songs (usuario, id_musica) VALUES
('ravi', 1),
('ravi', 4),
('ravi', 5);


INSERT INTO playlist (nome, descricao, usuario) VALUES
('playlist1', 'descricao playlist1', 'a');

INSERT INTO playlist_songs(id_playlist, id_musica) VALUES
(1, 1);



/*
select m.nome as nome_musica, al.nome as nome_album, art.nome as nome_arista, m.duracao
                     from musica m
                     inner join album al on al.id_album = m.id_album
                     inner join artista art on art.id_artista = al.id_artista
*/


/*
DROP TABLE IF EXISTS playlist, playlist_songs, musica, album, usuario, artista, liked_songs, unliked_songs, historico CASCADE;
*/


