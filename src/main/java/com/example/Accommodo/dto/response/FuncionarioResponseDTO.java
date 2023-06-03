package com.example.Accommodo.dto.response;

import com.example.Accommodo.entity.Funcionario;
import com.example.Accommodo.entity.Reserva;

import java.util.List;

public record FuncionarioResponseDTO(Integer id , String nome, String cargo, Double salario) {
    public FuncionarioResponseDTO(Funcionario funcionario) {
        this(funcionario.getId(), funcionario.getNome(), funcionario.getCargo(),funcionario.getSalario());
    }

}
