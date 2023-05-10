package src.main.java.com.hotel.model;

import src.main.java.com.hotel.enums.StatusQuarto;
import src.main.java.com.hotel.enums.TiposQuarto;

public class Quarto {
    private String nome;
    private int numero;
    private int andar;
    private TiposQuarto tipo;
    private int capacidade;
    private double precoDiaria;
    protected StatusQuarto status = StatusQuarto.DISPONIVEL;

    public Quarto() {
    }

    public Quarto(String nome, int numero, int andar, TiposQuarto tipo, int capacidade, double precoDiaria) {
        this.nome = nome;
        this.numero = numero;
        this.andar = andar;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.precoDiaria = precoDiaria;
    }

    public Quarto(String nome, int numero, int andar, TiposQuarto tipo, int capacidade, double precoDiaria, StatusQuarto status) {
        this.nome = nome;
        this.numero = numero;
        this.andar = andar;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.precoDiaria = precoDiaria;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public int getAndar() {
        return andar;
    }

    public TiposQuarto getTipo() {
        return tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public StatusQuarto getStatus() {
        return status;
    }

    public void setStatus(StatusQuarto status) {
        this.status = status;
    }
}
  