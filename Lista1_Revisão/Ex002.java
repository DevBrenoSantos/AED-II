// Breno Amaral Santos - C02177
package Lista1_Revisão;

import java.util.Scanner;
public class Ex002 {
    // Faça um programa em que receba n fornecido pelo usuário, e exiba a sequência
    // Fibonacci (Utilize a estrutura for) com seus n primeiros elementos.
    // Para n = 11
    // Mostre: 1 1 2 3 5 8 13 21 34 55 89  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numN;
        
        // Recebendo o valor de n termos
        System.out.print("Digite um valor para n: ");
        numN = input.nextInt();
        
        for (int i = 1; i < (numN+1); i++){
            System.out.print(" " + fibo(i));
        }
        input.close();
    }

    // Método para calcular a sequência de Fibonacci
    static int fibo(int n){
        if (n < 2) {
            return n;
        } else {
            return fibo(n-1) + fibo(n-2);
        }
    }

}
