package com.example.Accommodo.entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Pessoa {

    @Column(name = "nome", nullable = false)
    protected String nome;

    @Column(name = "email")
    protected String email;

    @Column(name = "telefone", nullable = false)
    protected String telefone;

    public Pessoa() {
    }

    public Pessoa(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome +
                ", Email: " + this.email +
                ", Telefone " + this.telefone;
    }
}
