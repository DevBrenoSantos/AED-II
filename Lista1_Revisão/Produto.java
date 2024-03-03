// Breno Amaral Santos - C02177
package Lista1_Revisão;

public class Produto {
    // Crie uma classe para o seguinte diagrama de classe UML
    private int id;
    private String descricao = "";
    private float preco;
    private int quant;
    private static int cont = 0;

    // Método construtor
    public Produto(String d, float p, int q) {
        this.descricao = d;
        this.preco = p;
        this.quant = q;
        cont++;
    }

    // Métodos
    public static int getCont() {
        return cont;
    }

    public int getId() {
        return id;
    }

    public boolean emEstoque() {
        return quant > 0;
    }

    public void setDescricao(String d) {
        this.descricao = d;
    }

    public void setPreco(float p) {
        this.preco = p;
    }

    public void setQuant(int q) {
        this.quant = q;
    }

    public float getPreco() {
        return preco;
    }

    Produto() {

    }

    public String toString() {
        return "ID: " + id + "\nDescrição: " + descricao + "\nPreço: " + preco + "\nQuantidade: " + quant;
    }
}
