package Lista9_PilhaFlexível;

import TerminalColors.Colors;
import java.util.EmptyStackException;

public class pilhaFlexivelRefactored {
    private Node sentinela;
    private int size;

    public pilhaFlexivelRefactored() {
        sentinela = new Node(0); // A célula sentinela não contém dados relevantes
        size = 0;
    }

    public void inserirElemento(int data) {
        Node newNode = new Node(data);
        newNode.next = sentinela.next;
        sentinela.next = newNode;
        size++;
    }

    public void removerElemento() {
        if (sentinela.next == null) {
            throw new EmptyStackException();
        }
        sentinela.next = sentinela.next.next;
        size--;
    }

    public int tamanhoPilha() {
        return size;
    }

    public boolean verificarPilha() {
        return sentinela.next == null;
    }

    public void imprimirPilha() {
        if (sentinela.next == null) {
            Colors.print("Pilha vazia!", Colors.RED_UNDERLINED);
            return;
        }
        Node current = sentinela.next;
        Colors.print("Elementos da pilha: ", Colors.BLUE_BOLD);
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    // Método recursivo para calcular a soma dos elementos da pilha
    public int somarPilha(Node node) {
        if (node == null) {
            return 0;
        }
        return node.data + somarPilha(node.next);
    }

    // Método WRAPPER para chamar o método recursivo
    public int somarPilha() {
        return somarPilha(sentinela.next);
    }

    public int maiorElemento() {
        if (sentinela.next == null) {
            throw new EmptyStackException();
        }

        int max = sentinela.next.data;
        Node current = sentinela.next.next;

        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }

        return max;
    }

    // Método recursivo para mostrar os elementos na ordem em que serão removidos
    private void mostrarElementosRecursivo(Node node) {
        if (node == null) {
            return;
        }
        int data = node.data;
        removerElemento();
        mostrarElementosRecursivo(sentinela.next);
        System.out.println(data);
        inserirElemento(data); // Reempilha o elemento para manter a pilha original intacta
    }

    // Método WRAPPER para chamar o método recursivo
    public void mostrarElementosRecursivo() {
        mostrarElementosRecursivo(sentinela.next);
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        pilhaFlexivelRefactored pilha = new pilhaFlexivelRefactored();
        pilha.inserirElemento(1);
        pilha.inserirElemento(2);
        pilha.inserirElemento(3);
        pilha.inserirElemento(4);
        pilha.inserirElemento(5);

        System.out.println("Elementos da pilha na ordem em que serão removidos:");
        pilha.mostrarElementosRecursivo();
    }
}
