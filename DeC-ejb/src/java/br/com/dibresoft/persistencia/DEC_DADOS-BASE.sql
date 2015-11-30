-- DADOS FICTÍCIOS: HOTEL --
INSERT INTO app.DEC_HOTEL (ID, STATUS, TITULO, TELEFONE, EMAIL)
  VALUES (1, 1, 'São Paulo | Vila Campo Grande', '(11) 5682-7300', 'sp.saopaulo.campogrande');


-- DADOS FICTÍCIOS: ENDERECO DE HOTEL --
INSERT INTO app.DEC_ENDERECO (ID, STATUS, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO, PAIS, CEP, HOTEL_ID)
  VALUES (1, 1, 'Av. Eng. Eusébio Stevaux', '823', '', 'Vila Campo Grande', 'São Paulo', 'SP', 'Brasil', '04696-000', 1);


-- DADOS FICTÍCIOS: CATEGORIAS DE QUARTO --
INSERT INTO app.DEC_CATEGORIA (ID, STATUS, TITULO, VALOR)
  VALUES (1, 1, 'Solteiro', 149.90),
         (2, 1, 'Solteiro Duplo', 249.90),
         (3, 1, 'Casal', 199.90),
         (4, 1, 'Casal Duplo', 349.90),
         (5, 1, 'Conjulgado', 399.90);


-- DADOS FICTÍCIOS: QUARTOS --
INSERT INTO app.DEC_QUARTO (ID, STATUS, TITULO, CATEGORIA_ID, HOTEL_ID)
  VALUES (1, 1, '1010', 1, 1),
         (2, 1, '1020', 2, 1),
         (3, 1, '1030', 3, 1),
         (4, 1, '1040', 4, 1),
         (5, 1, '1050', 5, 1);