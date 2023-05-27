package com.example.Accommodo.dto.response;

import com.example.Accommodo.entity.Quarto;

public record QuartoResponseDTO(Integer id, Integer numero, String tipo, Double preco, String status) {
    public QuartoResponseDTO(Quarto quarto) {
        this(quarto.getId(), quarto.getNumero(), quarto.getTipo(), quarto.getPreco(), quarto.getStatus());
    }
}
