CREATE TABLE Servico
(
    nome VARCHAR(50),
    descricao TEXT,
    valor DECIMAL(10,2) NOT NULL,
    id_quarto BIGINT NOT NULL,
    PRIMARY KEY (nome),
    FOREIGN KEY (id_quarto) REFERENCES Quarto(id)
);