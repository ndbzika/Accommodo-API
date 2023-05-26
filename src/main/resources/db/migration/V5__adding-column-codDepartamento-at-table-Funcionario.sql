ALTER TABLE Funcionario ADD codDepartamento INT;
ALTER TABLE Funcionario ADD CONSTRAINT Ref FOREIGN KEY (codDepartamento) REFERENCES Departamento(id);