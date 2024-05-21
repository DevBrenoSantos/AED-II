package Lista9_PilhaFlexível;

public class mainClass {
    public static void main(String[] args) {
        pilhaFlexivel pilhaTeste = new pilhaFlexivel();

        // Inserir Elementos
        pilhaTeste.inserirElemento(5);
        pilhaTeste.inserirElemento(10);
        pilhaTeste.inserirElemento(15);
        
        // Mostrar Elementos
        pilhaTeste.imprimirPilha();

        // Remover Elementos
        pilhaTeste.removerElemento();

        // Mostrar após remoção
        pilhaTeste.imprimirPilha();

        // Verificar o tamanho da pilha
        System.out.println("Tamanho da pilha: " + pilhaTeste.tamanhoPilha());

        // Verificar se a pilha está vazia
        System.out.println("A pilha está vazia? " + (pilhaTeste.verificarPilha() ? "Sim" : "Não"));

        // Somar os termos da pilha 
        System.out.println(pilhaTeste.somarPilha());

        // Retornar o maior elemento da pilha
        System.out.println(pilhaTeste.maiorElemento());
    }
}
