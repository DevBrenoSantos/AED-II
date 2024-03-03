package Lista3_Excecoes;

import java.util.Scanner;
public class Ex003 {
    // Metedo para calcular o fatorial
    public static int fatorial(int numero) {
        int fat = 1;
        try {
            int n = 1;
            while (++n <= numero) {
                fat *= n;
            }
            if (numero > 20) {
                throw new EntradaInvalida("Número negativo");
            }
        } catch (Exception e) {
            System.out.println("Insira um numero positivo menor que 20.");
            System.exit(0);
        }
        return fat;
    }

    // Main para testar o método fatorial
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o número para calcular o fatorial: ");
        int numero = input.nextInt();
        
        System.out.println(fatorial(numero));
        
        input.close();
    }
}

// Classe da exceção
class EntradaInvalida extends Exception {
    public EntradaInvalida(String msg) {
        super(msg);
    }
}