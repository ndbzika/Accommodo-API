public class Quarto {
    private String nome;
    private int numero;
    private int andar;
    private String tipo;
    private int capacidade;
    private double precoDiaria;
    private boolean disponivel = true;

    public Quarto(String nome, String tipo, double precoDiaria) {
        this.nome = nome;
        this.tipo = tipo;
        this.precoDiaria = precoDiaria;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAndar() {
        return this.andar;
    }
    public void setAndar(int andar) {
        this.andar = andar;
    }

    public int getNumero() {
        return this.numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidade() {
        return this.capacidade;
    }
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getPrecoDiaria() {
        return this.precoDiaria;
    }
    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
  