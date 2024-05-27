package Lista10_ListaLinearEDupla;

@SuppressWarnings("rawtypes")
public class ListaDupla<T> {
    private CelulaDupla primeiro;
    private CelulaDupla ultimo;
    public ListaDupla() {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }
    
    public int tamanho(){
        int n = 0;
        CelulaDupla i = primeiro.getProx();
        while (i != null){
            n++;
            i = i.getProx();
        }
        return n;
    }

    public boolean listaVazia(){
        return tamanho() == 0;
    }
    
    @SuppressWarnings("unchecked")
    public void inserirInicio(T x) throws Exception{
        CelulaDupla tmp = new CelulaDupla<>(x);
        tmp.setAnt(primeiro);
        tmp.setProx(primeiro.getProx());
        primeiro.setProx(tmp);
        if (primeiro == ultimo)
            ultimo = tmp;
        else
            tmp.getProx().setAnt(tmp);
        tmp = null;
    }

    @SuppressWarnings("unchecked")
    public T removerInicio() throws Exception{
        if (primeiro == ultimo)
            throw new Exception("Erro!");
        CelulaDupla tmp = primeiro;
        primeiro = primeiro.getProx();
        T elemento = (T) primeiro.getElemento();
        tmp.setProx(null);
        tmp = null;
        return elemento;
    }

    @SuppressWarnings("unchecked")
    public void inserirFim(T x){
        ultimo.setProx(new CelulaDupla<>(x));
        ultimo = ultimo.getProx();
    }

    @SuppressWarnings("unchecked")
    public T removerFim() throws Exception{
        if (primeiro == ultimo)
            throw new Exception("Erro!");
        CelulaDupla i;
        for(i = primeiro; i.getProx() != ultimo; i = i.getProx());
        T elemento = (T) ultimo.getElemento();
        ultimo = i;
        i = null;
        ultimo.setProx(null);
        return elemento;
    }

    @SuppressWarnings("unchecked")
    public void inserir(T x, int pos) throws Exception{
        int tamanho = tamanho();
        if (pos < 0 || pos > tamanho)
            throw new Exception("Erro!");
        else if (pos == 0)
            inserirInicio(x);
        else if (pos == tamanho)
            inserirFim(x);
        else {
            CelulaDupla i;
            CelulaDupla tmp = new CelulaDupla(x);
            if (pos <= tamanho/2){
                i = primeiro;
                for (int j = 0; j < pos; j++, i = i.getProx());
                tmp.setProx(i.getProx());
                i.setProx(tmp);
            }
            else if (pos > tamanho/2) {
                i = ultimo;
                for (int j = tamanho; j > pos; j--, i = i.getAnt());
                tmp.setAnt(i.getAnt());
                i.setAnt(tmp);
            }
            tmp = null;
            i = null;
        }
    }

    @SuppressWarnings("unchecked")
    public T remover(int pos) throws Exception{
        T elemento = null;
        int tamanho = tamanho();
        if (primeiro == ultimo || pos < 0 || pos >= tamanho)
            throw new Exception("Erro!");
        else if (pos == 0)
            elemento = removerInicio();
        else if (pos == tamanho - 1)
            elemento = removerFim();
        else {
            CelulaDupla i;
            CelulaDupla tmp = null;
            if (pos <= tamanho/2){
                i = primeiro;
                for (int j = 0; j < pos; j++, i = i.getProx());
                tmp = i.getProx();
                i.setProx(tmp.getProx());
            }
            else if (pos > tamanho/2) {
                i = ultimo;
                for (int j = tamanho; j > pos; j--, i = i.getAnt());
                tmp = i.getAnt();
                i.setAnt(tmp.getAnt());
            }
            elemento = (T) tmp.getElemento();
            tmp.setProx(null);
            tmp.setAnt(null);
            i = null;
            tmp = null;
        }
        return elemento;
    }

    public void mostrar(){
        System.out.print("[");
        CelulaDupla i = primeiro.getProx();
        while (i!=null){
            System.out.print(i.getElemento()+" ");
            i = i.getProx();
        }
        System.out.print("]\n");
    }
}
