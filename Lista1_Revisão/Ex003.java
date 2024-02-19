package Lista1_Revisão;

import java.util.Scanner;
public class Ex003 {
    // Faça uma função que receba como parâmetro n calcule a soma real da seguinte
    // expressão:
    // • S = 1 + 1 / 2 + 1/3 + 1 / 4 +...+ 1/n
     public static void main(String[] args) {
          Scanner input = new Scanner(System.in);
          int numN;

          // Recebendo o valor de n
          System.out.print("Digite o parâmetro 'n' para a soma real da expressão: ");
          numN = input.nextInt();

          // Imprimindo a soma real da expressão
          System.out.println("A soma real da expressão é: " + somaReal(numN));
          input.close();
     } 

     // Método para calcular a soma real da expressão
     static double somaReal(int n){
          double soma = 0;
          for (int i=1; i<=n; i++){
               soma += 1.0/i;
          }
          return soma;
     }
}
