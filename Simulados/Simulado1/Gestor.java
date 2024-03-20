package Simulados.Simulado1;

public class Gestor extends Empregado {
    private int nivel;
    private String celularCorporativo;

    // Constructor
    public Gestor(int id, String nome, float salario) throws Exception {
        super(id, nome, salario);
        //TODO Auto-generated constructor stub
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getCelularCorporativo() {
        return celularCorporativo;
    }

    public void setCelularCorporativo(String celularCorporativo) {
        this.celularCorporativo = celularCorporativo;
    }

    @Override
    public String toString() {
        return "Gestor [nivel=" + nivel + ", celularCorporativo=" + celularCorporativo + "]";
    }
}
