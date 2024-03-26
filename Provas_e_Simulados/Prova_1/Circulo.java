public class Circulo {
    private int X;
    private int Y;
    private int raio;

    public Circulo(int x, int y, int raio) {
        X = x;
        Y = y;
        setRaio(this.raio);
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        try {
            if(raio < 0)
                throw new raioNegativo("O valor do raio não pode ser negativo.");
            this.raio = raio;
        } catch (raioNegativo e) {
        }
    }

    public double calculaArea(int raio) {
        double areaCirculo = (3.14 * (raio*raio));
        return areaCirculo;
    }

    public double calculaCircunferencia(int raio){
        double cincunferencia = (2*3.14*raio);
        return cincunferencia;
    }
}

class raioNegativo extends Exception {
    public raioNegativo(String msg) {
        super(msg);
    }
}