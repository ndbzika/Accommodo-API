public class Funcionario {
  private String nome;
  private String cargo;
  private double salario;
  private String email;
  private String telefone;

  public Funcionario(String nome, String cargo, String email, double salario, String telefone){
    this.nome = nome;
    this.cargo = cargo;
    this.email = email;
    this.salario = salario;
    this.telefone = telefone;
  }

  public String getNome() { return this.nome; }
  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCargo() {
    return this.cargo;
  }
  public void setCargo(String cargo) { this.cargo = cargo; }

  public double getSalario() {
    return this.salario;
  }
  public void setSalario(double salario) {
    this.salario = salario;
  }

  public String getEmail() {
    return this.email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefone() {
    return this.telefone;
  }
  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
}