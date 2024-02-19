// Breno Amaral Santos - C02177
package Lista1_Revisão;

import java.util.Scanner;
public class Ex001 {
    // Faça um programa que receba um valor de n (inteiro) positivo maior que 1 e o número
    // m, que representa o número de vezes que a sequência deve-se repetir de 0 até n. Na
    // primeira linha o número deve ser em sequência crescente e, na segunda linha deve ser
    // decrescente. Esta série deve alternar até completar o número m de repetições inseridas
    // pelo usuário.
    // Ex: n = 9
    // repetições = 4
    //  0 1 2 3 4 5 6 7 8 9
    //  9 8 7 6 5 4 3 2 1 0
    //  0 1 2 3 4 5 6 7 8 9
    //  9 8 7 6 5 4 3 2 1 0 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numN, repeticions, contador = 0;

        // Recebendo os valores de n e m    
        System.out.print("Digite um valor para n (positivo maior que 1): ");
        numN = input.nextInt();

        System.out.print("Digite um valor para m (número de repetições): ");
        repeticions = input.nextInt();

        // Imprimindo a sequência
        for (int i=0; i<repeticions; i++){
            if (contador < repeticions) {
                for (int j=0; j<=numN; j++){
                    System.out.print(j + " ");
                }
                contador++;
            }
            System.out.println();
            

            if (contador < repeticions) {
                for (int j=numN; j>=0; j--){
                    System.out.print(j + " ");
                } 
                contador++;
            }
            if (contador == repeticions) {
                break;
            }
            System.out.println();
        }
        input.close();
    }
}