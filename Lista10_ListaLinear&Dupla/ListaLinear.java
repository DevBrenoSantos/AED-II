// Lista linear com tipo genérico

public class ListaLinear<T> {
    private Object[] array;
    private int n;

    ListaLinear() {
        this(10);
    }

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
}