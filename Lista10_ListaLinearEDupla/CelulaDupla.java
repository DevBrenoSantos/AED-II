package Lista10_ListaLinearEDupla;

public class CelulaDupla <T>{
    private T elemento;
    private CelulaDupla <T>ant;
    private CelulaDupla <T> prox;
    public CelulaDupla(){
        this(null);
    }
    public CelulaDupla(T x) {
        this.elemento = x;
        this.ant = null;
        this.prox = null;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public CelulaDupla<T> getAnt() {
        return ant;
    }

    public void setAnt(CelulaDupla<T> ant) {
        this.ant = ant;
    }

    public CelulaDupla<T> getProx() {
        return prox;
    }

    public void setProx(CelulaDupla<T> prox) {
        this.prox = prox;
    }
}
