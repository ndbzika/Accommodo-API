CREATE TABLE Reserva
(
    id BIGINT,
    id_hospede BIGINT NOT NULL,
    id_quarto BIGINT NOT NULL,
    data_checkIn DATE NOT NULL,
    data_checkOut DATE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_hospede) REFERENCES Hospede(id),
    FOREIGN KEY (id_quarto) REFERENCES Quarto(id)
);