package Lista6_Ordenação.Eficientes;

public class Shellsort {
    public static void shellSort(double[] v) {
        int i, j, h=1;
        double value;
        do {
            h= 3 * h + 1;

        } while (h<v.length);
        do {
            h= h/3;
            for(i=h; i<v.length; i++) {
                value = v[i];
                j = i-h;
                while (j>=0 && value < v[j]) {
                    v[j+h] = v[j];
                    j=j-h;
                }
                v[j+h] = value;
            }
        } while(h>1);
    }
}
