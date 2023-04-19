public class Hospede {
  private String nome;
  private String email;
  private String telefone;
  private String documento;

  public Hospede(String nome, String email, String documento, String telefone) {
    this.nome = nome;
    this.email = email;
    this.documento = documento;
    this.telefone = telefone;
  }

  public String getNome() {
    return this.nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTelefone() {
    return this.telefone;
  }
  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return this.email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getDocumento() {
    return this.documento;
  }
  public void setDocumento(String documento) {
    this.documento = documento;
  }
}
