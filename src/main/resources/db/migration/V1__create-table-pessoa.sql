CREATE TABLE PESSOA
(
    cpf CHAR(11) PRIMARY KEY,
    nome VARCHAR(50),
    email VARCHAR(50) UNIQUE,
    telefone VARCHAR(50) UNIQUE,
    data_nascimento DATE
);