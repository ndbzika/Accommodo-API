CREATE TABLE Departamento
(
    id INT,
    nome VARCHAR(20) NOT NULL UNIQUE,
    gerente INT,
    PRIMARY KEY (id),
    FOREIGN KEY (gerente) REFERENCES Funcionario(id)
);