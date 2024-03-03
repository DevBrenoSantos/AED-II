package Lista3_Excecoes;

import java.util.Scanner;
public class Ex002 {
    // Modifique o código abaixo para que ele lance uma exceção quando acontecer uma divisão por zero. 
    // Metodo da divisão
    public static double divisao(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return (double) a / b;
    }

    // Main para testar o método divisão
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Digite o numerador: ");
            int a = input.nextInt();
            System.out.print("Digite o denominador: ");
            int b = input.nextInt();
            System.out.println("Resultado: " + divisao(a, b));
            input.close();
        } catch (ArithmeticException e) {
            System.err.print("Divisão por zero, operação inválida.");
        }
    }
}