package Estudos.Ex001;

public class ContaBancaria {
    private Double saldo;
    private String numeroConta;

    public ContaBancaria(double saldo, String numeroConta) {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void sacar(double valor) {
        Double novoSaldo = null;
        do {
            try {
                if (valor < 0) {
                    throw new IllegalArgumentException("Valor de saque inválido");
                } if (valor > saldo) {
                    throw new IllegalArgumentException("Saldo insuficiente");
                } else {
                    novoSaldo = saldo - valor;
                    System.out.println("Saque efetuado com sucesso!");
                    System.out.println("==============================");
                    System.out.println("Dados da conta:");
                    System.out.println("Conta: " + numeroConta);
                    System.out.println("Saldo anterior: " + saldo);
                    System.out.println("Valor sacado: " + valor);
                    System.out.println("Saldo atual: " + novoSaldo);
                    System.out.println("==============================");
                    setSaldo(novoSaldo);
                }
            } catch (IllegalArgumentException e) {
                System.err.println("");
            }
        } while (novoSaldo == null);
    }

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1000.0, "123456");
        conta.sacar(1000.0);
    }
}