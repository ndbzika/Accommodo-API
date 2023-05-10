package src.main.java.com.hotel.model;

public class Funcionario extends Pessoa {
  private int id;
  private String cargo;
  protected double salario;
  public Funcionario() {
  }

  public Funcionario(String nome, String email, String telefone, String documento, String cargo, double salario) {
    super(nome, email, telefone, documento);
    this.cargo = cargo;
    this.salario = salario;
  }


  public String getCargo() {
    return this.cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public double getSalario() {
    return this.salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    if (id<0){
      return;
    }
    this.id = id;
  }
}