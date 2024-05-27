package Lista10_ListaLinearEDupla;

// Lista linear com tipo genérico
public class ListaLinear<T> {
    private Object[] array;
    private int n;

    ListaLinear() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    ListaLinear(int tamanho) {
        array = (T[]) new Object[tamanho];
        n = 0;
    }

    void inserirInicio(int x) throws Exception {
        if (n >= array.length) {
            throw new Exception("Erro");
        }

        // Levar elementos para o fim do array
        for (int i = n; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = x;
        n++;
    }

    void inserirFim(int x) throws Exception {
        if (n >= array.length) {
            throw new Exception("Erro");
        }

        array[n] = x;
        n++;
    }

    void inserirPosicao(int x, int pos) throws Exception {
       if (n >= array.length || pos < 0 || pos > n) {
            throw new Exception("Erro");
        }

        // Levar elementos para o fim do array
        for (int i = n; i > pos; i--) {
            array[i] = array[i - 1];
        }

        array[pos] = x;
        n++;
    }

    void removerInicio() throws Exception {
        if (n == 0) {
            throw new Exception("Erro");
        }

        // Levar elementos para o início do array
        for (int i = 0; i < n - 1; i++) {
            array[i] = array[i + 1];
        }

        n--;
    }

    void removerFim() throws Exception {
        if (n == 0) {
            throw new Exception("Erro");
        }

        n--;
    }

    void removerPosicao(int pos) throws Exception {
        if (n == 0 || pos < 0 || pos >= n) {
            throw new Exception("Erro");
        }

        // Levar elementos para o início do array
        for (int i = pos; i < n - 1; i++) {
            array[i] = array[i + 1];
        }

        n--;
    }

    int listaTamanho() {
        return n;
    }

    boolean listaVazia() {
        return n == 0;
    }

    void listaMostrar() {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}