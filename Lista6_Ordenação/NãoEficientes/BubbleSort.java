package Lista6_Ordenação.NãoEficientes;

public class BubbleSort {
    public static double[] bubbleSort(double[] vet) {
        double aux;
        int n=vet.length;
        for (int i = n-1; i>0; i--) {
            for (int j=n-1; j>n-i-1; j--) {
                if(vet[j] > vet [j-1]) {
                    aux = vet[j];
                    vet[j] = vet[j-1];
                    vet[j-1] = aux;
                }
            }
        }
        return (vet);
    }
}