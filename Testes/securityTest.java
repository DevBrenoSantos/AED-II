package Testes;

import java.lang.reflect.Field;
import sun.misc.Unsafe;
public class securityTest {
    public static Integer fatorial(Integer T) {
        Integer resp;
        if (T == 0) {
            resp = 1;
        } else {
            resp = T * fatorial(T - 1);
        }
        return resp;
    }

    public static void main(String[] args) throws InterruptedException {
        Unsafe unsafe = null;
        // Suprimindo a exceção de segurança
        try {
            Field field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (sun.misc.Unsafe) field.get(null);

        } catch (Exception e) {
            throw new AssertionError(e);
        }
        
        for (int i = 0; i < 65; i++) {
            System.out.println();
            Thread.sleep(10);
            Integer valor = fatorial(i);
            System.out.println(valor);
            unsafe.getAddress(valor);
        }
    }
}