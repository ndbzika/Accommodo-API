CREATE TABLE Quarto
(
   id SERIAL PRIMARY KEY,
   id_hotel INT NOT NULL,
   numero SMALLINT UNIQUE NOT NULL,
   andar SMALLINT NOT NULL,
   ocupado BOOLEAN NOT NULL,
   preco_diaria DECIMAL(10,2) NOT NULL,
   vagas SMALLINT NOT NULL,
   FOREIGN KEY (id_hotel) REFERENCES Hotel(id)
);