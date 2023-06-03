package com.example.Accommodo.dto.request;

import com.example.Accommodo.entity.Reserva;

import java.util.List;

public record FuncionarioRequestDTO(String nome, String email, String telefone,String cargo, Double salario) {
}
