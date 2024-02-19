// Breno Amaral Santos - C02177
package Lista1_Revisão;

import java.util.Scanner;

public class Ex004 {
    // Crie um procedimento que Receba uma Matriz M e imprima a matriz transposta
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Recebendo o número de linhas e colunas da matriz
        int linhas, colunas;
        System.out.print("Digite o número de linhas da matriz: ");
        linhas = input.nextInt();
        System.out.print("Digite o número de colunas da matriz: ");
        colunas = input.nextInt();

        // Criando a matriz
        int[][] matriz = new int[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("Digite o valor da posição - Linha [" + i + "] Coluna [" + j + "]: ");
                matriz[i][j] = input.nextInt();
            }
        }

        // Imprimindo a matriz original
        System.out.println("Matriz original:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Chamando o método para imprimir a matriz transposta
        matrizTransposta(matriz);

        input.close();
    }

    static void matrizTransposta(int[][] matriz) {
        int linhas = matriz.length;
        int colunas = matriz[0].length;

        // Crir a matriz transposta
        int[][] transposta = new int[colunas][linhas];

        // preencher a matriz transposta
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                transposta[j][i] = matriz[i][j];
            }
        }

        // Imprimir a matriz transposta
        System.out.println("Matriz transposta: ");
        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                System.out.print(transposta[i][j] + " ");   
            }
            System.out.println();
        }
    }
}