package Lista6_Ordenação.Eficientes;

public class HeapSort {
    public static void heapSort(double[] array) {
        int n = array.length;

        // Construir um max-heap
        for(int i=(n/2-1); i>=0; i--) {
            heapify(array, n, i);
        }

        // Extrair elementos do heap um por um
        for (int i=n-1; i>0; i--) {
            // move a raiz(o maior elemento) para o final do array
            double temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Chama o heapify na sub-árvore reduzida
            heapify(array, i, 0);
        }
    }

    public static void heapify(double[] array, int n, int i) {
        int largest = i; // Inicializa o maior como a raiz
        int left = 2*i+1; // Índice do filho esquerdo
        int right=2*i+2; // Índice do filho direito

        // Se o filho esquerdo for maior que a raiz
        if (left<n && array[left] > array[largest]) {
            largest = left;
        }

        // Se o filho direito for maior que o maior até agora
        if (right<n && array[right]>array[largest]) {
            largest=right;
        }

        // Se o maior não for a raiz
        if (largest != i) {
            double swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            // Recursivamente chama o heapify na sub-árvore afetada
            heapify(array, n, largest);
        }
    }
}
