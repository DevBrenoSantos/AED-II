import java.util.Scanner;

public class controller {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws raioNegativo{
        Scanner input = new Scanner(System.in);
        int X, Y, raio;
        double area, cincunferencia;
        System.out.println("Insira o valor de x: ");
        X = input.nextInt();

        System.out.println("Insira o valor de Y: ");
        Y = input.nextInt();

        System.out.println("Insira o valor do raio: ");
        raio = input.nextInt();
        try {
            if(raio <0)
                throw new raioNegativo("O valor do raio não pode ser negativo.");
            Circulo teste = new Circulo(X, Y, raio);
            System.out.println(teste.calculaArea(raio));
            System.out.println(teste.calculaCircunferencia(raio));
        } catch (raioNegativo e) {
            System.out.println("Erro ao inserir o valor do raio. " + e.getMessage());
        }

        // Ignorar, não faz parte da prova
        area = 0;
        System.out.println(area);
        cincunferencia = 0;
        System.out.println(cincunferencia);

        input.close();
    }
}