-- DADOS FICTÍCIOS: HOTEL --
INSERT INTO app.DEC_HOTEL (ID, STATUS, TITULO, TELEFONE, EMAIL)
  VALUES (1, true, 'São Paulo | Vila Campo Grande', '(11) 5682-7300', 'sp.saopaulo.campogrande');


-- DADOS FICTÍCIOS: ENDERECO DE HOTEL --
INSERT INTO app.DEC_ENDERECO (ID, STATUS, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO, PAIS, CEP, HOTEL_ID)
  VALUES (1, true, 'Av. Eng. Eusébio Stevaux', 823, '', 'Vila Campo Grande', 'São Paulo', 'SP', 'Brasil', '04696-000', 1);


-- DADOS FICTÍCIOS: CATEGORIAS DE QUARTO --
INSERT INTO app.DEC_CATEGORIA (ID, STATUS, TITULO, VALOR)
  VALUES (1, true, 'Solteiro', 149.90),
         (2, true, 'Solteiro Duplo', 249.90),
         (3, true, 'Casal', 199.90),
         (4, true, 'Casal Duplo', 349.90),
         (5, true, 'Conjulgado', 399.90);


-- DADOS FICTÍCIOS: QUARTOS --
INSERT INTO app.DEC_QUARTO (ID, STATUS, TITULO, CATEGORIA_ID, HOTEL_ID)
  VALUES (1, true, '1010', 1, 1),
         (2, true, '1020', 2, 1),
         (3, true, '1030', 3, 1),
         (4, true, '1040', 4, 1),
         (5, true, '1050', 5, 1);