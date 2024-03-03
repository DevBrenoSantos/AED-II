package Lista3_Excecoes.Ex001;

import javax.swing.JOptionPane;
public class Banco {
    public static void main(String[] args) {
        // Obtem dados
        String nome = typeString("Digite o nome do cliente");
        String cpf = typeString("Digite o cpf do cliente");
        double saldo = typeDouble("Digite o saldo inicial do cliente");

        Conta c = new Conta(nome, cpf, saldo);
        double deposito = typeDouble("Digite o valor do deposito");
        c.deposita(deposito);

        double saque = typeDouble("Digite o valor do saque");

        try {
            c.saca(saque);
        } catch(SaldoInsuficienteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\nOperação não realizada!");
        }
        JOptionPane.showMessageDialog(null, c.toString());
    }

    // Métodos para entrada de dados
    private static double typeDouble(String txt) {
        Double d = null;
        do {
            try {
            String userInput = JOptionPane.showInputDialog(txt);
            d = Double.parseDouble(userInput);
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "\n Formato de entrada inválida, tente novamente");
        }
    } while (d == null);
        return d;
    }

    // Métodos para entrada de dados
    private static String typeString(String txt) {
        return JOptionPane.showInputDialog(null, txt);
    }
}