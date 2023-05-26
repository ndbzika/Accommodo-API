CREATE TABLE Servico
(
    nome VARCHAR(15) PRIMARY KEY,
    descricao TEXT,
    valor DECIMAL(5,2) NOT NULL,
    id_quarto INT NOT NULL,
    FOREIGN KEY (id_quarto) REFERENCES Quarto(id)
);