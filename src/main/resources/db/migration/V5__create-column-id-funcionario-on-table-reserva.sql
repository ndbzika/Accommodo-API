ALTER TABLE RESERVA
    ADD COLUMN id_funcionario INT,
    ADD CONSTRAINT fk_reserva_funcionario
        FOREIGN KEY (id_funcionario)
        REFERENCES FUNCIONARIO (id);
