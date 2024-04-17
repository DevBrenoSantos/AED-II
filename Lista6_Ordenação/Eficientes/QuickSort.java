package Lista6_Ordenação.Eficientes;

public class QuickSort {
    public static void quickSort(double[] array, int esq, int dir) {
        int i = esq, j = dir;
        double pivo = array[(dir+esq)/2];
        while (i<=j) {
            while(array[i]<pivo) i++;
            while(array[j]>pivo) j--;
            if(i<=j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if(esq<j) quickSort(array, esq, j);
        if(i<dir) quickSort(array, i, dir);
    }

    public static void swap(double[] array, int i, int j) {
        double temp=array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
