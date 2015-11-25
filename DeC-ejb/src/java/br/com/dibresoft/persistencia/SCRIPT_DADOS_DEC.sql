INSERT INTO app.DEC_CLIENTE (ID,NOME, SEXO, DATANASCIMENTO, CPF, RG, EMAIL, SENHA, NEWSLETTER, PRIVACIDADE, STATUS) 
	VALUES 
          (1,'Udimberto', 'M', '2015-10-08', 'Teste', 'Teste', 'Teste', '123456', 1, 1,1),
          (2,'Luciano', 'M', '2015-10-08', 'Teste', 'Teste', 'Teste', '123456', 1, 1,1),
          (3,'Fabio', 'M', '2015-10-08', 'Teste', 'Teste', 'Teste', '123456', 1, 1,1),
          (4,'Larissa', 'F', '2015-10-08', 'Teste', 'Teste', 'Teste', '123456', 1, 0,1),
          (5,'Thiago', 'M', '2015-10-08', 'Teste', 'Teste', 'Teste', '123456', 1, 1,1),
          (6,'Renato', 'M', '2015-10-08', 'Teste', 'Teste', 'Teste', '123456', 1, 1,1);

INSERT INTO app.DEC_ENDERECO (ID, BAIRRO, CEP, CIDADE, COMPLEMENTO, ESTADO, LOGRADOURO, NUMERO, PAIS, STATUS) 
	VALUES
          (1, 'Santa Teresa', '04403060', 'Rio de Janeiro', '', 'RJ', 'Jurubatuba', '1502', 'Brasil', 1),
          (2, 'Copacabana', '04403102', 'Rio de Janeiro', '', 'RJ', 'Santo Amaro', '2345', 'Brasill', 1),
          (3, 'Bela Vista', '04403191', 'São Paulo', '', 'SP', 'Av. Paulista', '250', 'Brasil', 1),
          (4, 'Maragogi', '04402127', 'Alagoas', '', 'AL', 'Av. Francisco almeida', '1230', 'Brasil', 1);


INSERT INTO app.DEC_HOTEL (ID, STATUS, TITULOHOTEL, ENDERECO_ID) 
	VALUES 
           (1, 1, 'Rio de Janeiro' , 1),
           (2, 1, 'Rio de Janeiro II' , 2),
           (3, 1, 'São Paulo' , 3),
           (4, 1, 'Maceió' , 4);

INSERT INTO app.DEC_QUARTO (ID, NOME, STATUS, VALOR, HOTEL_ID) 
	VALUES 
          (1, 'Simples', '1',150.55, 1),
          (2, 'Simples', '1',122.00, 2),
          (3, 'Simples', '1',122.00, 3),
          (4, 'Simples', '1',122.00, 4),
          (5, 'Luxo', '1',1500.00, 1),
          (6, 'Luxo', '1',1232.00, 2),
          (7, 'Luxo', '1',2002.00, 3),
          (8, 'Luxo', '1',2150.00, 4);

INSERT INTO app.DEC_RESERVA (ID, CHECKIN, CHECKOUT, STATUS, VALORESTADIA, CLIENTE_ID, QUARTO_ID) 
	VALUES 
           (1, '2015-11-12', '2015-11-14', 1, 250.0, 1, 1),
           (2, '2015-11-12', '2015-11-16', 1, 300.0, 2, 2),
           (3, '2015-11-12', '2015-11-14', 1, 175.0, 2, 3),
           (4, '2015-11-12', '2015-11-17', 1, 2280.0, 3, 4),
           (5, '2015-11-12', '2015-11-19', 1, 250.0, 4, 5),
           (6, '2015-11-12', '2015-11-15', 1, 250.0, 5, 6),
           (7, '2015-11-12', '2015-11-18', 1, 250.0, 6, 7),
           (8, '2015-11-12', '2015-11-13', 1, 250.0, 1, 8);

	