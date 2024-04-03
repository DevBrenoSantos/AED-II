package Testes;

import java.lang.reflect.Field;
import sun.misc.Unsafe;
public class alocamentoUnsafeTest {
    public static void main(String[] args) {
        Unsafe unsafe = null;
        // Suprimindo a exceção de segurança   
        try {
            Field field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (sun.misc.Unsafe) field.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
        int ten = 10;
        byte size = 1;
        long mem = unsafe.allocateMemory(size);
        unsafe.putAddress(0x0000000704a0000, ten);
        long readValue = unsafe.getAddress(mem);
        System.out.println("Value: " + readValue);
    }
}