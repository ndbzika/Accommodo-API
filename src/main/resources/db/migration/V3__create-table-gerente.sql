CREATE TABLE GERENTE
(
    departamento VARCHAR(20),
    matricula_funcionario BIGINT,
    FOREIGN KEY (matricula_funcionario) REFERENCES FUNCIONARIO(matricula)
);