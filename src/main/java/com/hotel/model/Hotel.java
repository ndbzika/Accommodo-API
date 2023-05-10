package src.main.java.com.hotel.model;

import src.main.java.com.hotel.enums.StatusQuarto;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class Hotel {
  private String nome;
  private String endereco;
  private int estrelas;
  private List<Quarto> quartos;
  private List<Funcionario> funcionarios;
  private List<Servico> servicos;
  private List<Reserva> reservas;
  private List<Hospede> hospedes;

  public Hotel(String nome, int estrelas) {
    this.nome = nome;
    this.estrelas = estrelas;
  }

  public String getNome() {
    return this.nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getEstrelas() {
    return this.estrelas;
  }
  public void setEstrelas(int estrelas) {
    this.estrelas = estrelas;
  }

  public String getEndereco() {
    return this.endereco;
  }
  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  ///////////////////////////////////////////////////
  //implementar try catch para as funções a seguir
  public boolean adicionarQuarto(Quarto quarto) {
    if (this.quartos.contains(quarto)){
      System.out.printf("\nQuarto n° %d já está na lista de quartos.\n",quarto.getNumero());
      return false;
    }
    this.quartos.add(quarto);
    return this.quartos.contains(quarto);
  }
  public boolean removerQuarto(Quarto quarto) {
    if (!this.quartos.contains(quarto)){
      System.out.println("\nO quarto especificado não está na lista de quartos.");
      return false;
    }
    this.quartos.remove(quarto);
    return true;
  }
  public List<Quarto> buscarQuartosDisponiveis(Date dataCheckIn, Date dataCheckOut) {
    // criar lógica para comparar datas
    List<Quarto> quartosDisponiveis = new ArrayList<Quarto>();
    for(Quarto quarto : this.quartos) {
      if (quarto.getStatus() == StatusQuarto.DISPONIVEL) {
        quartosDisponiveis.add(quarto);
      }
    }
    return quartosDisponiveis;
  }

  public boolean adicionarFuncionario(Funcionario funcionario) {
    if (this.funcionarios.contains(funcionario)) {
      System.out.printf("O funcionário %s já está na lista de funcionarios.",funcionario.getNome());
      return false;
    }
    this.funcionarios.add(funcionario);
    return true;
  }
  public boolean removerFuncionario(Funcionario funcionario) {
    if (!this.funcionarios.contains(funcionario)) {
      System.out.println("Funcionário especificado não está na base de dados.");
      return false;
    }
    this.funcionarios.remove(funcionario);
    return true;
  }

  public boolean adicionarServico(Servico servico) {
    if (this.servicos.contains(servico)) {
      System.out.printf("%s já está na lista de serviços.",servico.getNome());
      return false;
    }
    this.servicos.add(servico);
    return true;
  }
  public boolean removerServico(Servico servico) {
    if (!this.servicos.contains(servico)) {
      System.out.println("O serviço informado não está na lista de serviços.");
      return false;
    }
    this.servicos.remove(servico);
    return true;
  }

//  public List<Servico> listarServicos(List<Servico> servicos) {
//    // criar atributo e método em serviço para saber se está disponivel.
//    // implementar para caso o serviço esteja disponivel seja informado aqui.
//  }

  public boolean registrarReserva(Reserva reserva) {
    Quarto quartoDaReserva = reserva.getQuarto();
    this.reservas.add(reserva);
    for(Quarto quarto : this.quartos) {
      if (quarto.equals(quartoDaReserva)) quarto.setStatus(StatusQuarto.OCUPADO);
    }
    return true;
  }
  public boolean cancelarReserva(Reserva reserva) {
    Quarto quartoDaReserva = reserva.getQuarto();
    this.reservas.remove(reserva);
    for(Quarto quarto : this.quartos) {
      if (quarto.equals(quartoDaReserva)) quarto.setStatus(StatusQuarto.DISPONIVEL);
    }
    return true;
  }

  public boolean registrarCheckin(Reserva reserva) {
    Date dataAtual = new Date();
    reserva.setDataCheckIn(dataAtual);
    return true;
  }
  public boolean registrarCheckout(Reserva reserva) {
    Date dataAtual = new Date();
    reserva.setDataCheckOut(dataAtual);
    return true;
  }
  public boolean listarReservas(){
    for(Reserva reserva : this.reservas) {
      System.out.println(reserva.getId() + " - " + reserva.getQuarto() + " (" + reserva.getDataCheckIn() + " - " + reserva.getDataCheckOut() + ") ");
    }
    return true;
  }
  public void listarHospedes() {
    for(Hospede hospede : this.hospedes) {
      System.out.println(hospede.getNome() + " - " + hospede.getTelefone());
    }
  }

  public boolean adicionarHospede(Hospede hospede) {
    this.hospedes.add(hospede);
    return true;
  }

}
