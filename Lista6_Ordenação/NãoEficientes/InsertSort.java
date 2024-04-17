package Lista6_Ordenação.NãoEficientes;

public class InsertSort {
    public static double[] insertSort(double[] vet) {
        double chave;
        int j;
        for (int i=1; i<vet.length;i++) {
            chave=vet[i];
            j=i-1;
            while(j>=0 && vet[j] > chave) {
                vet[j+1] = vet[j];
                j=j-1;
            }
            vet[j+1] = chave;
        }
        return (vet);
    }
}
