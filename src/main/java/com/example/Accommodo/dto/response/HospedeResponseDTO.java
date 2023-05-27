package com.example.Accommodo.dto.response;

import com.example.Accommodo.entity.Hospede;

public record HospedeResponseDTO(Integer id, String nome, String email, String telefone) {
    public HospedeResponseDTO(Hospede hospede) {
        this(hospede.getId(), hospede.getNome(), hospede.getEmail(), hospede.getTelefone());
    }
}
