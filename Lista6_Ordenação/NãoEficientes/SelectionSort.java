package Lista6_Ordenação.NãoEficientes;

public class SelectionSort {
    public static double[] selectionSort(double[] vet) {
        int menor;
        for(int fixo=0; fixo<vet.length-1; fixo++) {
            menor = fixo;
            for (int i=menor+1; i<vet.length; i++) {
                if (vet[i] < vet[menor]) {
                    menor=i;
                }
                if (menor!=fixo) {
                    double aux = vet[fixo];
                    vet[fixo] = vet[menor];
                    vet[menor] = aux;
                }
            }
        }
        return (vet);
    }
}
