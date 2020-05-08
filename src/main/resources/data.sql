INSERT INTO TAB_MUNICIPIO(id, nome, uf) VALUES (null, 'Caceres', 'MT');
INSERT INTO TAB_MUNICIPIO(id, nome, uf) VALUES (2, 'Chapada dos Guimarae', 'MT');
INSERT INTO TAB_MUNICIPIO(id, nome, uf) VALUES (3, 'Cuiaba', 'MT');
INSERT INTO TAB_MUNICIPIO(id, nome, uf) VALUES (4, 'Rondonopolis', 'MT');
INSERT INTO TAB_MUNICIPIO(id, nome, uf) VALUES (5, 'Sinop', 'MT');
INSERT INTO TAB_MUNICIPIO(id, nome, uf) VALUES (6, 'Sorriso', 'MT');
INSERT INTO TAB_MUNICIPIO(id, nome, uf) VALUES (7, 'Tangara da Serra', 'MT');
INSERT INTO TAB_MUNICIPIO(id, nome, uf) VALUES (8, 'Varzea Grande', 'MT');

INSERT INTO TAB_INDIVIDUO_ENDERECO(id, logradouro, complemento, bairro, municipio_id) VALUES (1, 'logradouro a', 'complemento a', 'bairro a', 1);
INSERT INTO TAB_INDIVIDUO_ENDERECO(id, logradouro, complemento, bairro, municipio_id) VALUES (2, 'logradouro b', 'complemento b', 'bairro b', 2);

INSERT INTO TAB_INDIVIDUO(id, nome, data_nascimento, email, endereco_id) VALUES (1,'JOSE SILVA', '1900-11-01', 'josesilva@email.com', 1);
INSERT INTO TAB_INDIVIDUO(id, nome, data_nascimento, email, endereco_id) VALUES (2,'MARIA SILVA', '1900-11-01', 'mariasilva@email.com', 2);

INSERT INTO TAB_INDIVIDUO_TELEFONE (id, ddd, numero, individuo_id) VALUES (null,'21', '36255514', 1);
INSERT INTO TAB_INDIVIDUO_TELEFONE (id, ddd, numero, individuo_id) VALUES (null,'21', '988887777', 1);
INSERT INTO TAB_INDIVIDUO_TELEFONE (id, ddd, numero, individuo_id) VALUES (null,'65', '988887777', 1);
INSERT INTO TAB_INDIVIDUO_TELEFONE (id, ddd, numero, individuo_id) VALUES (null,'65', '977776666', 2);
