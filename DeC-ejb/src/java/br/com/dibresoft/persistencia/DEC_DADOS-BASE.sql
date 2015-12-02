-- DADOS FICTÍCIOS: HOTEL --
INSERT INTO app.DEC_HOTEL (ID, STATUS, TITULO, TELEFONE, EMAIL) VALUES
  (1, 1, 'São Paulo | Vila Campo Grande', '(11) 5682-7300', 'sp.saopaulo.campogrande@lebrehotel.com.br'),
  (2, 1, 'Rio de Janeiro | Ipanema', '(21) 2525-2525', 'rj.rio.ipanema@lebrehotel.com.br'),
  (3, 1, 'Porto de Galinhas | Ipojuca', '(81) 2126-2160', 'pe.portodegalinhas@lebrehotel.com.br');


-- DADOS FICTÍCIOS: ENDERECO DE HOTEL --
INSERT INTO app.DEC_ENDERECO (ID, STATUS, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO, PAIS, CEP, HOTEL_ID) VALUES
  (1, 1, 'Av. Eng. Eusébio Stevaux', '823', '', 'Vila Campo Grande', 'São Paulo', 'SP', 'Brasil', '04696-000', 1),
  (2, 1, 'Av. Vieira Souto', '460', '', 'Ipanema', 'Rio de Janeiro', 'RJ', 'Brasil', '22420-006', 2),
  (3, 1, 'Loteamento Merepe II', 'S/N', '', 'Ipojuca', 'Porto de Galinhas', 'PE', 'Brasil', '55590-000', 3);


-- DADOS FICTÍCIOS: CATEGORIAS DE QUARTO --
INSERT INTO app.DEC_CATEGORIA (ID, STATUS, TITULO, VALOR)VALUES
  (1, 1, 'Solteiro', 149.90),
  (2, 1, 'Solteiro Duplo', 249.90),
  (3, 1, 'Casal', 199.90),
  (4, 1, 'Casal Duplo', 349.90),
  (5, 1, 'Conjulgado', 399.90);


-- DADOS FICTÍCIOS: QUARTOS --
INSERT INTO app.DEC_QUARTO (ID, STATUS, TITULO, CATEGORIA_ID, HOTEL_ID) VALUES
  (01, 1, '1010', 1, 1),
  (02, 1, '1020', 2, 1),
  (03, 1, '1030', 3, 1),
  (04, 1, '1040', 4, 1),
  (05, 1, '1050', 5, 1),

  (06, 1, '1010', 1, 2),
  (07, 1, '1020', 2, 2),
  (08, 1, '1030', 3, 2),
  (09, 1, '1040', 4, 2),
  (10, 1, '1050', 5, 2),

  (11, 1, '1010', 1, 3),
  (12, 1, '1020', 2, 3),
  (13, 1, '1030', 3, 3),
  (14, 1, '1040', 4, 3),
  (15, 1, '1050', 5, 3);