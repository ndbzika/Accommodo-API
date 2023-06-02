CREATE TABLE Quarto
(
    id BIGINT,
    id_hotel BIGINT,
    numero SMALLINT UNIQUE NOT NULL,
    andar SMALLINT NOT NULL,
    ocupado BOOLEAN NOT NULL,
    preco_diaria DECIMAL(10,2) NOT NULL,
    vagas SMALLINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_hotel) REFERENCES Hotel(id)
);