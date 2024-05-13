package Provas_e_Simulados.Simulado2;

public class funRecursiva {
    public static void main(String[] args) {
            System.out.println(potencia(5, 3));
    }
    
    public static int potencia(int num, int exp) {
        if (exp==1)
            return num;
        else 
            return (potencia(num, exp-1)*num);
    }
}