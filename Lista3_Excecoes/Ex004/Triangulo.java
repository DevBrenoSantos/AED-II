package Lista3_Excecoes.Ex004;

public class Triangulo {
    double lado1, lado2, lado3;

    public Triangulo(double lado1, double lado2, double lado3) {
        try {
            // Tratando casos excepicionais (lados negativos ou iguais a zero, e lados que não formam um triângulo)
            if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
                throw new TrianguloInvalidoError("Lados não podem ser menores ou iguais a zero.");
            }

            if (lado1 + lado2 < lado3 || lado1 + lado3 < lado2 || lado2 + lado3 < lado1) {
                throw new TrianguloInvalidoError("Não é possível formar um triângulo com esses lados.");
            }
        
            // Constructor
            this.lado1 = lado1;
            this.lado2 = lado2;
            this.lado3 = lado3;
        } catch (TrianguloInvalidoError e) {
            System.err.println("Insira um triângulo válido.");
        }
    }
    
    public int determinarTipo() {
        try {
            if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
                throw new TrianguloInvalidoError("Lados não podem ser menores ou iguais a zero.");
            }

            if (lado1 + lado2 < lado3 || lado1 + lado3 < lado2 || lado2 + lado3 < lado1) {
                throw new TrianguloInvalidoError("Não é possível formar um triângulo com esses lados.");
            }

        // Determinando o tipo dos triângulos
        if (lado1 == lado2 && lado2 == lado3) {
            // Triângulo equilátero
            return 0;
        } else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
            // Triângulo isósceles
            return 1;
        } else {
            // Triângulo escaleno
            return 2;
        }
    } catch (TrianguloInvalidoError e) {
        System.err.println("Erro ao determinar o tipo do triângulo.");
        }
        return -1;
    }

}

// Classe da exceção
class TrianguloInvalidoError extends Exception{
    public TrianguloInvalidoError(String msg) {
        super(msg);
    }
}