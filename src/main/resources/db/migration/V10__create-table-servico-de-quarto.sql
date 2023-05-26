CREATE TABLE SERVICOQUARTO
(
    data_servico DATE NOT NULL,
    nome_servico VARCHAR(50),
    numero_quarto SMALLINT,
    PRIMARY KEY (nome_servico, numero_quarto),
    FOREIGN KEY (nome_servico) REFERENCES SERVICO(nome),
    FOREIGN KEY (numero_quarto) REFERENCES QUARTO(numero)
);