CREATE TABLE FUNCIONARIO
(
    cpf_pessoa CHAR(11) UNIQUE,
    matricula BIGINT PRIMARY KEY,
    cargo VARCHAR(20),
    salario DECIMAL(10,2) NOT NULL,
    CHECK ( salario > 1350 ),
    FOREIGN KEY (cpf_pessoa) REFERENCES Pessoa(cpf)
);