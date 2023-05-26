ALTER TABLE Funcionario ADD id_hotel INT;
ALTER TABLE Funcionario ADD FOREIGN KEY (id_hotel) REFERENCES Hotel(id);