package src.main.java.com.hotel.model;

public class Gerente extends Funcionario{
    private String departamento;
    public Gerente(String nome, String cargo, String email, double salario, String telefone, String departamento) {
        super(nome, cargo, email, salario, telefone);

        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
