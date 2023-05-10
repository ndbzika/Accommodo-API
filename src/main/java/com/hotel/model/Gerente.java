package src.main.java.com.hotel.model;

public class Gerente extends Funcionario{
    private String departamento;

    public Gerente() {
    }

    public Gerente(String nome, String email, String telefone, String documento, String cargo, double salario, String departamento) {
        super(nome, email, telefone, documento, cargo, salario);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public boolean GivePromotionTo(Funcionario funcionario, double valorAumento) {
        if (funcionario == null) return false;
        if (funcionario.getId() == this.getId()) return false;

        double novoSalario = funcionario.getSalario() + valorAumento;
        funcionario.setSalario(novoSalario);

        return true;
    }
}
