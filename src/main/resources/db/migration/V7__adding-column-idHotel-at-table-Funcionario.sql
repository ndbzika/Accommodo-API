ALTER TABLE Funcionario ADD id_hotel BIGINT;
ALTER TABLE Funcionario ADD FOREIGN KEY (id_hotel) REFERENCES Hotel(id);