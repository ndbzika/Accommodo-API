CREATE TABLE funcionario
(
    id BIGINT,
    id_pessoa BIGINT,
    cargo VARCHAR(30),
    salario DECIMAL(10,2),
    supervisor INT,
    PRIMARY KEY (id),
    FOREIGN KEY (id_pessoa) REFERENCES Pessoa(id),
    FOREIGN KEY (supervisor) REFERENCES funcionario(id)
);