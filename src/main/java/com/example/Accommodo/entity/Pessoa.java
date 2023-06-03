package com.example.Accommodo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Pessoa {

    @Column(name = "nome", nullable = false)
    protected String nome;

    @Column(name = "email")
    protected String email;

    @Column(name = "telefone", nullable = false)
    protected String telefone;
}
