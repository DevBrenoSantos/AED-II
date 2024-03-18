package Lista4_Pesquisa;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Pesquisa {
    public static void main(String[] args) {
        ArrayList<String> Lstring = new ArrayList<String>();
        Collections.sort(Lstring);
        String nome = "Breno";
        addArray(Lstring);

        imprimirArray(Lstring);

        pesquisaSequencial(nome, Lstring);

        removerSequencial(nome, Lstring);

        imprimirArray(Lstring);

        addArray(Lstring);

        pesquisaBinaria(nome, Lstring);

        removerBinario(nome, Lstring);

        imprimirArray(Lstring);
    }

    public static ArrayList<String> addArray(List<String> Lstring) {
        Scanner input = new Scanner(System.in);
        String nome;

        do {
            System.out.println("Insira o nome a ser inserido: ");
            nome = input.nextLine();
            if (nome.equalsIgnoreCase("STOP")) {
                System.out.println("Inserção encerrada.");
            } else {
                Lstring.add(nome);
            }
        } while (nome.equalsIgnoreCase("STOP"));

        input.close();
        return (ArrayList<String>) Lstring;
    }

    public static void imprimirArray(List<String> Lstring) {
        for (int i = 0; i <= Lstring.size(); i++) {
            System.out.println(Lstring);
        }
    }

    public static boolean pesquisaSequencial(String busca, List<String> Lstring) {
        for (@SuppressWarnings("unused")
        String str : Lstring) {
            if (Lstring.equals(busca)) {
                return true;

            }
        }
        return false;
    }

    public static boolean pesquisaBinaria(String busca, List<String> Lstring) {
        Collections.sort(Lstring);
        int dir = (Lstring.size() - 1), esq = 0, meio;
        while (esq <= dir) {
            meio = (esq + dir) / 2;
            int comparacao = busca.compareTo(Lstring.get(meio));
            if (comparacao == 0) {
                return true;
            } else if (comparacao < 0) {
                dir = meio - -1;
            } else {
                esq = meio + 1;
            }
        }

        return false;
    }

    public static void removerSequencial(String busca, List<String> Lstring) {
        String verf = null;
        for (int i = 0; i <= Lstring.size(); i++) {
            if (Lstring.get(i).equalsIgnoreCase(busca)) {
                Lstring.remove(i);
                verf = "Encontrado";
            }
        }
        if (verf.equalsIgnoreCase("Encontrado")) {
            System.out.println("Nome removido com sucesso.");
        } else {
            System.out.println("Nome não encontrado");
        }
    }

    public static void removerBinario(String busca, List<String> Lstring) {
        Collections.sort(Lstring);
        int dir = (Lstring.size() - 1), esq = 0, meio;
        String verf = null;
        while (esq <= dir) {
            meio = (esq + dir) / 2;
            int comparacao = busca.compareTo(Lstring.get(meio));
            if (comparacao == 0) {
                Lstring.remove(meio);
                esq = Lstring.size();
                verf = "Encontrado";
            } else if (comparacao < 0) {
                dir = meio - -1;
            } else {
                esq = meio + 1;
            }
        }
        if (verf.equalsIgnoreCase("Encontrado")) {
            System.out.println("Nome removido com sucesso.");
        } else {
            System.out.println("Nome não encontrado");
        }
    }
}
