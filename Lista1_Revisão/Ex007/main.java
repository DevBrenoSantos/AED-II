package Lista1_Revisão.Ex007;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
    // Crie um programa que ofereça ao usuário as seguintes opções:
    // a) Crie um procedimento que escreva em um arquivo texto números digitados
    // pelo usuário.
    // b) Crie um procedimento que leia números escritos em um arquivo (item
    // anterior) e depois mostre a soma desses números.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("1 - Escrever em um arquivo");
            System.out.println("2 - Ler um arquivo e mostrar a soma dos números");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = input.nextInt();

            if (opcao == 0) {
                System.out.println("Fim do programa.");
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    escreverNumeros();
                    break;
                case 2:
                    lerArquivo_e_ExibirSoma();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 0);
    }

    public static void escreverNumeros() {
        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Digite os números separados por espaços:");
            String numeros = input.nextLine();

            BufferedWriter writer = new BufferedWriter(new FileWriter("numeros.txt"));
            writer.write(numeros);
            writer.close();

            System.out.println("Números gravados no arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());

        }
    }

    public static void lerArquivo_e_ExibirSoma() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("numeros.txt"));

            String linha = reader.readLine();
            String[] numerosString = linha.split(" ");

            int soma = 0;
            for (String numStr : numerosString) {
                int numero = Integer.parseInt(numStr);
                soma += numero;
            }

            System.out.println("Soma dos números lidos do arquivo: " + soma);

            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler do arquivo: " + e.getMessage());
        }
    }
}
