package Lista3_Excecoes.Ex001;

public class Conta {
    private double saldo;
    private String nome, cpf;
    private double Limite = 200;

    // Constructor
    public Conta(String nome, String cpf, double saldo) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setSaldo(saldo);
    }
    
    public double getLimite() {
        return Limite;
    }

    public void setLimite(double limite) {
        this.Limite = limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = (saldo < 0) ? 0:saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void deposita (double valor) {
        setSaldo((valor < 0) ? saldo:saldo+valor);
    }

    // Método para saque
    public void saca(double valor) throws SaldoInsuficienteException {
        // Saldo é suficiente para saque
        if(getSaldo() > valor) {
            setSaldo(getSaldo()-valor);
        } if ((getSaldo() + getLimite() > valor)) {
            double novoLimite = (getSaldo()+getLimite()) - valor;
            setSaldo(0);
            if (novoLimite < 0) {
                setLimite(0);
            } else {
                setLimite(novoLimite);
            }
        } else {
            throw new SaldoInsuficienteException("Seu saldo é: " + this.saldo + "\n Você tentou sacar: " + valor);
        }
    }
    
    // Método para exibir informações (ToString)
    @Override
    public String toString() {
        return "Cliente: " + this.nome + "\nCPF: " + this.cpf + "\nSaldo: " + this.saldo;
    }
}