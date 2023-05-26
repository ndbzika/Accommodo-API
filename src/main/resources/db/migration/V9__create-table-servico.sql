CREATE TABLE SERVICO
(
    nome VARCHAR PRIMARY KEY,
    valor DECIMAL(8,2),
    descricao TEXT,
    mat_funcionario BIGINT NOT NULL,
    FOREIGN KEY (mat_funcionario) REFERENCES FUNCIONARIO(matricula)
);