package Lista3_Excecoes.Ex004;

public class Controller {
    // Main para testar a classe Triangulo
    public static void main(String[] args) {
        Triangulo t1 = new Triangulo(3, 4, 5);
        System.out.println(t1.determinarTipo());
        
        Triangulo t2 = new Triangulo(3, 3, 3);
        System.out.println(t2.determinarTipo());
        
        Triangulo t3 = new Triangulo(3, 3, 4);
        System.out.println(t3.determinarTipo());
        
        Triangulo t4 = new Triangulo(0, 3, 6);
        System.out.println(t4.determinarTipo());
    }
}
