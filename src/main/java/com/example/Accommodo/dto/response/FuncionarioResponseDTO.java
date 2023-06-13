package com.example.Accommodo.dto.response;

import com.example.Accommodo.entity.Funcionario;
import com.example.Accommodo.entity.Reserva;

import java.util.List;

public record FuncionarioResponseDTO(Integer id , String nome, String email, String telefone ,String cargo, Double salario) {
    public FuncionarioResponseDTO(Funcionario funcionario) {
        this(funcionario.getId(), funcionario.getNome(), funcionario.getEmail(), funcionario.getTelefone(), funcionario.getCargo(),funcionario.getSalario());
    }

}
