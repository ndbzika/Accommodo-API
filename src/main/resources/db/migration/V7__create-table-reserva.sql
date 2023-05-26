CREATE TABLE RESERVA
(
    data_checkOut DATE,
    data_checkIn DATE,
    id BIGINT PRIMARY KEY,
    cpf_hospede CHAR(11),
    CHECK ( data_checkOut > data_checkIn ),
    FOREIGN KEY (cpf_hospede) REFERENCES HOSPEDE(cpf_pessoa)
);