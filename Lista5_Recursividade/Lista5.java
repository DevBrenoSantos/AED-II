public class Lista5 {
    public static void main(String[] args) {
       int[] lista = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };
        // ex1(lista, lista.length);
        // System.out.println(ex2(4, 2));
        // System.out.println(ex3(500));
        // System.out.println(ex4(1234));
        // System.out.println(ex5(2, 3));
        // System.out.println(ex6(2, 2, 7));
        // System.out.println(ex7(lista, 8, 0));
        // System.out.println(ex08(2, 8));
        // System.out.println(ex09(arr, arr.length));
    }

    public static void ex1(int[] array, int n) {
        if (n == 0)
            return;
        System.out.println(array[n-1]);
        ex1(array, n-1);
    }

    public static int ex2(int a, int b) {
        if (b > a)
            return 0;
        return 1 + ex2(a-b, b);
    }
    
    public static int ex3(int a) {
        if (a == 0)
            return 0;
        return 1 + ex3(a /10);
    }

    public static int ex4(int a) {
        if (a == 0) return 0;
        return a % 10 + ex4(a / 10);
    }

    public static int ex5(int a, int b) {
        if (b == 0) return 0;
        return a + ex5(a, b-1);
    }

    public static int ex6(int p, int r, int n) {
        if (n == 0) return p;
        return ex6(p * r, r, n-1);
    }

    public static int ex7(int[] array, int k, int posicao) {
        if (array[posicao] == k) 
            return posicao;
        if (posicao == array.length) 
            return -1;
        return ex7(array, k, posicao+1);
    }

    public static int ex08(int n, int e) {
        if (e == 1) return n;
        return n * ex08(n, e - 1);
    }

    public static int ex09(int[] arr, int n) {
        int m;

        if (n - 1 == 0) return arr[0];
        m = ex09(arr, n - 1);
        if (arr[n - 1] < m) m = arr[n - 1];
        return m;
    }

    public static int ex10(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;
        return ex10(n - 1) * ex10(n - 2) - ex10(n - 1); 
    }
}