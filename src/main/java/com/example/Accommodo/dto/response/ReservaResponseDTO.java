package com.example.Accommodo.dto.response;

import com.example.Accommodo.entity.Funcionario;
import com.example.Accommodo.entity.Hospede;
import com.example.Accommodo.entity.Quarto;
import com.example.Accommodo.entity.Reserva;

import java.time.LocalDate;

public record ReservaResponseDTO (Integer id, Hospede hospede, Quarto quarto, Funcionario funcionario, LocalDate dataInicio, LocalDate dataFim, String status){
    public ReservaResponseDTO(Reserva reserva) {
        this(reserva.getId(), reserva.getHospede(), reserva.getQuarto(), reserva.getFuncionario(), reserva.getDataInicio(), reserva.getDataFim(), reserva.getStatus());
    }
}
