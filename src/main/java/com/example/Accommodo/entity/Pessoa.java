package com.example.Accommodo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Pessoa {
    protected String nome;
    protected String email;
    protected String telefone;
}
