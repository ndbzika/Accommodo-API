package com.example.Accommodo.dto.request;

import com.example.Accommodo.entity.Funcionario;
import com.example.Accommodo.entity.Hospede;
import com.example.Accommodo.entity.Quarto;

public record ReservaRequestDTO (Hospede hospede, Funcionario funcionario ,Quarto quarto, String dataInicio, String dataFim, String status){
}
