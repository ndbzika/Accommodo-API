package com.example.Accommodo.dto.request;

import com.example.Accommodo.entity.Funcionario;
import com.example.Accommodo.entity.Hospede;
import com.example.Accommodo.entity.Quarto;

import java.time.LocalDate;

public record ReservaRequestDTO (Hospede hospede, Quarto quarto, Funcionario funcionario, LocalDate dataInicio, LocalDate dataFim, String status){
}
