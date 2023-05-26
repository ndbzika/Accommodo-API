CREATE TABLE Gerente
(
    id INT PRIMARY KEY,
    id_funcionario INT NOT NULL,
    data_inicio DATE NOT NULL,
    FOREIGN KEY (id_funcionario) REFERENCES Funcionario(id)
);