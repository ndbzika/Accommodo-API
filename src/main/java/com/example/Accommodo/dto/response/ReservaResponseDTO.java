package com.example.Accommodo.dto.response;

import com.example.Accommodo.entity.Funcionario;
import com.example.Accommodo.entity.Hospede;
import com.example.Accommodo.entity.Quarto;
import com.example.Accommodo.entity.Reserva;

import java.time.LocalDate;
import java.util.Date;

public record ReservaResponseDTO (Integer id, Hospede hospede, Funcionario funcionario ,Quarto quarto, Date dataInicio, Date dataFim, String status){
    public ReservaResponseDTO(Reserva reserva) {
        this(reserva.getId(), reserva.getHospede(), reserva.getFuncionario(),reserva.getQuarto(),reserva.getDataInicio(), reserva.getDataFim(), reserva.getStatus());
    }
}
