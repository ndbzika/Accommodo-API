CREATE TABLE reserva (
     id INT PRIMARY KEY,
     quarto_id INT,
     hospede_id INT,
     data_inicio DATE NOT NULL,
     data_fim DATE NOT NULL,
     status VARCHAR(20) NOT NULL,
     FOREIGN KEY (quarto_id) REFERENCES quarto(id),
     FOREIGN KEY (hospede_id) REFERENCES hospede(id)
);