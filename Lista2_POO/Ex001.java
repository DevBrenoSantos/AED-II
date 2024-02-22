// Breno Amaral Santos - C02177
package Lista2_POO;

import java.util.Scanner;
public class Ex001 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pessoa pessoa1 = new Pessoa("João", "Silva");
        Funcionario pessoa2 = new Funcionario("Nome", "Medeiros", 1750.00);
        Professor pessoa3 = new Professor("José", "Souza", -500.00);
        Professor pessoa4 = new Professor("Ana", "Oliveira", 1500.00);

        System.out.println("Nomes Completos:");
        System.out.println(pessoa1.getNomeCompleto());
        System.out.println(pessoa2.getNomeCompleto());
        System.out.println(pessoa3.getNomeCompleto());
        System.out.println(pessoa4.getNomeCompleto());

        System.out.println("");

        System.out.println("Exibindo os salário:");
        System.out.println(pessoa2.getNome()+ "\n Primeria parcela: " + pessoa2.getSalarioPrimeiraParcela() + "\n Segunda parcela: " + pessoa2.getSalarioSegundaParcela());
        System.out.println(pessoa3.getNome()+ "\n Primeria parcela: " + pessoa3.getSalarioPrimeiraParcela() + "\n Segunda parcela: " + pessoa3.getSalarioSegundaParcela());
        System.out.println(pessoa4.getNome()+ "\n Primeria parcela: " + pessoa4.getSalarioPrimeiraParcela() + "\n Segunda parcela: " + pessoa4.getSalarioSegundaParcela());

        input.close();
    }
}

class Pessoa {
    public String nome, sobrenome;

    public Pessoa(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public String getNomeCompleto() {
        return (nome + " " + sobrenome);
    }

}

class Funcionario extends Pessoa {
    private int matricula;
    private double salario;
    
    public Funcionario(String nome, String sobrenome, double salario) {
        super(nome, sobrenome);
        this.matricula = (int) Math.random();
        try {
            if (salario < 0) {
                IllegalArgumentException erro = new IllegalArgumentException();
                throw erro;
            } else {
                this.salario = salario;
            }
        } catch (IllegalArgumentException erro) {
            System.err.println("O salário não pode ser menor que 0");
        } 
    }

    public Funcionario(int matricula, double salario) {
        this.matricula = matricula;
        this.salario = salario;
    }

    public int getMatricula() {
        return matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setSalario(double salario) {
        try {
            if (this.salario < 0) {
                IllegalArgumentException erro = new IllegalArgumentException();
                throw erro;
            } else {
                this.salario = salario;
            }
        } catch (IllegalArgumentException erro) {
            System.err.println("O salário não pode ser menor que 0");
        }    
    }

    public double getSalarioPrimeiraParcela() {
        return (salario*0.6);
    }    

    public double getSalarioSegundaParcela() {
        return (salario*0.4);
    }
}

class Professor extends Funcionario{
    
    public Professor(String nome, String sobrenome, double salario) {
        super(nome, sobrenome, salario);
    }

    @Override
    public double getSalarioPrimeiraParcela() {
        return super.getSalario();
    }

    @Override
    public double getSalarioSegundaParcela() {
        return 0;
    }
}