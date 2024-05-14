package Lista9_PilhaFlexível;

import TerminalColors.Colors;
import java.util.EmptyStackException;

public class pilhaFlexivel {
    private Node top;
    private int size;

    public pilhaFlexivel() {
        top = null;
        size = 0;
    }

    public void inserirElemento(int data) {
        Node newNode = new Node(data);
        newNode.next= top;
        top = newNode;
        size++;
    }

    public void removerElemento() {
        if (top == null) {
            throw new EmptyStackException();
        }
        top = top.next;
        size--;
    }

    public int tamanhoPilha() {
        return size;
    }

    public boolean verificarPilha() {
        return top == null;
    }

    public void imprimirPilha() {
        if (top == null) {
            Colors.print("Pilha vazia!", Colors.RED_UNDERLINED);
            return;
        }
        Node current = top;
        Colors.print("Elementos da pilha: ", Colors.BLUE_BOLD);
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    // Método recursivo para calcular a soma dos elementos da pilha
    public int somarPilha(Node node) {
        if (node  == null) {
            return 0;
        }
        return node.data + somarPilha(node.next); 
    }

    // Método WRAPPER para chamar o método recursivo - Esse método fornece uma interface mais simples e intuitiva para os usuários da classe 'pilhaFlexivel'
    public int somarPilha() {
        return somarPilha(top);
    }

    public int maiorElemento() {
        if (top == null) {
            throw new EmptyStackException();
        }

        int max = top.data;
        Node current = top.next;

        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }

        return max;
    }

    // Método recursivo para mostrar os elementos na ordem em que serão removidos
    public void mostrarElementosRecursivo(Node node) {
        if (node == null) {
            return;
        }
        int data = node.data;
        removerElemento();
        mostrarElementosRecursivo(top);
        System.out.println(data);
        inserirElemento(data);
    }

    // Método WRAPPER para chamar o método recursivo
    public void mostrarElementosRecursivo() {
        mostrarElementosRecursivo(top);
    }
    
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
