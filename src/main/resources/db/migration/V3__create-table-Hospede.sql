CREATE TABLE Hospede (
    id BIGINT,
    id_pessoa BIGINT,
    data_cadastro DATE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_pessoa) REFERENCES Pessoa(id)
);