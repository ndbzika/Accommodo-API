CREATE TABLE QUARTO
(
    numero SMALLINT PRIMARY KEY,
    valor_diaria DECIMAL(10,2) NOT NULL,
    capacidade SMALLINT NOT NULL,
    status BOOLEAN,
    id_reserva BIGINT,
    andar SMALLINT,
    CHECK ( valor_diaria > 0 ),
    CHECK ( capacidade > 0 ),
    FOREIGN KEY (id_reserva) REFERENCES RESERVA(id)
);