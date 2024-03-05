package Testes;

import java.util.Scanner;

import Lista1_Revisão.Produto;
public class Controller {
    // Crie uma classe para o seguinte diagrama de classe UML
    // Classe controller com um método main que instancia um objeto da classe Produto e testa os métodos criados.
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        int opcao = 0;

        System.out.println("O que deseja fazer? \n1 - Cadastrar produto \n2 - Verificar estoque e quantidade\n3 - Verificar Id do produto\n4 - Definir descrição do produto\n5 - Definir preço do produto\n6 - Definir quantidade do produto\n9 - Sair");
        opcao = input.nextInt();

        if (opcao == 9) {
            System.out.println("Fim do programa.");
            System.exit(0);
        }

        switch (opcao) {
            case 1:
                String descricao, novo = "";
                float preco;
                int quant;

                do {
                    System.out.println("Para cadastrar, primeiro digite o preço do produto: ");
                    preco = input.nextFloat();

                    System.out.println("Agora, digite a quantidade do produto: ");
                    quant = input.nextInt();

                    input.nextLine();
                    System.out.println("Por fim, digite a descrição: ");
                    descricao = input.nextLine();

                    if (descricao.equals("") || preco == 0 || quant == 0) {
                        System.out.println("Por favor, preencha todos os campos.");
                        continue;
                    } else {
                        Produto newProduto = new Produto(descricao, preco, quant);
                        System.out.println("Produto cadastrado com sucesso!");
                        System.out.println("--------------PRODUTO---------------");
                        System.out.println(newProduto);
                        System.out.println("-----------------------------------");
                        System.out.println("Deseja cadastrar outro produto? (S/N)");
                        novo = input.nextLine();
                    }
                } while (novo.equalsIgnoreCase("s"));

                break;
            case 2:
                    
                break;
            case 3:
                
                break;
            case 4:
                    
                break;
            case 5:
                
                break;
            case 6:
                    
                break;
            default:
                break;
        }
        input.close();
    }
}
