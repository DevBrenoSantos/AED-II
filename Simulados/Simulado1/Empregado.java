package Simulados.Simulado1;

public class Empregado {
    private int id;
    private String nome;
    private float Salario;

    // Constructor
    public Empregado(int id, String nome, float salario) throws Exception {
        this.id = id;
        this.nome = nome;
        if (salario <= 0) {
            throw new Exception("O salário menor ou igual a 0");
        }
        this.Salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return Salario;
    }

    public void setSalario(float salario) throws Exception {
        if (salario <= 0) {
            throw new Exception("O salário menor ou igual a 0");
        }
        Salario = salario;
    }

    @Override
    public String toString() {
        return "Empregado [id=" + id + ", nome=" + nome + ", Salario=" + Salario + "]";
    }
}
