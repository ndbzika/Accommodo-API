CREATE TABLE funcionario
(
    id INT PRIMARY KEY,
    id_pessoa INT NOT NULL ,
    cargo VARCHAR(15),
    salario DECIMAL(10,2),
    FOREIGN KEY (id_pessoa) REFERENCES Pessoa(id)
);