CREATE TABLE Cliente (
    id INT PRIMARY KEY,
    id_pessoa INT NOT NULL,
    data_cadastro DATE NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_pessoa) REFERENCES Pessoa(id)
);