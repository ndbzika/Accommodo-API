CREATE TABLE Reserva
(
    id SERIAL PRIMARY KEY,
    id_hospede INT NOT NULL,
    id_quarto INT NOT NULL,
    data_checkIn DATE NOT NULL,
    data_checkOut DATE NOT NULL,
    FOREIGN KEY (id_hospede) REFERENCES Cliente(id),
    FOREIGN KEY (id_quarto) REFERENCES Quarto(id)
);