package Testes;

import sun.misc.Unsafe;
public class responseTest {
    public static Integer fatorial (Integer T) {
        Integer resp;
        if (T == 0) {
            resp = 1;
        } else {
            resp = T * fatorial(T - 1);
        }
        return resp;
    }

    public static void main(String[] args) throws InterruptedException {
        Unsafe unsafe = Unsafe.getUnsafe();
        @SuppressWarnings("unused")
        long start = System.currentTimeMillis();
        for (int i = 0; i < 65; i++) {
            System.out.println();
            Thread.sleep(10);
            Integer valor = fatorial(i);
            System.out.println(valor);  
            System.out.println(unsafe.getAddress(valor));
        }
    }
}