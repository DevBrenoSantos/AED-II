package Lista1_Revisão;

public class Ex005 {
    // Crie uma classe para o seguinte diagrama de classe UML
    private int id;
    private String descricao;
    private float preco;
    private int quant;
    private static int cont = 0;

    // Método construtor
    public Ex005(String descricao, float preco, int quant) {
        this.descricao = descricao;
        this.preco = preco;
        this.quant = quant;
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
}
