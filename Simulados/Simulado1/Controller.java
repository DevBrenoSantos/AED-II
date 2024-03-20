package Simulados.Simulado1;

public class Controller {
    public static void main(String[] args) {
        try {
            Empregado Teste = new Empregado(13657, "Breno", 1200);
            System.out.println(Teste);
            Empregado Teste1 = new Empregado(13657, "Breno", -1200);
            System.out.println(Teste1);
        } catch (Exception e) {
            System.out.println("O salário não pode ser menor ou igual a 0 - ('0').");
        }
    }
}
