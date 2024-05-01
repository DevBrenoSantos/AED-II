package Lista8_Fila;

public class Aplicativo {
    public static void main(String[] args) throws Exception {
      FilaEncadeada fila = new FilaEncadeada();
  
      fila.inserir(10);
      fila.inserir(12);
      fila.inserir(13);
      fila.inserir(14);
  
      fila.mostrar();
  
      fila.remover();
      fila.mostrar();
  
      System.out.println();
      //fila.mostrar();
      //System.out.println(fila.obterMenor());
    }
  }
  
  class NoFila {
    private int elemento;
    private NoFila proximoNo;
  
    public NoFila(int elemento, NoFila proximoNo) {
      this.elemento = elemento;
      this.proximoNo = proximoNo;
    }
  
    public int obterElemento() {
      return elemento;
    }
  
    public void definirElemento(int elemento) {
      this.elemento = elemento;
    }
  
    public NoFila obterProximoNo() {
      return proximoNo;
    }
  
    public void definirProximoNo(NoFila proximoNo) {
      this.proximoNo = proximoNo;
    }
  }
  
  class FilaEncadeada {
    private NoFila cabeca;
  
    public FilaEncadeada() {
      cabeca = new NoFila(0, null);
    }
  
    public void inserir(int elemento) {
      NoFila atual = cabeca;
  
      while (atual.obterProximoNo() != null)
        atual = atual.obterProximoNo();
  
      atual.definirProximoNo(new NoFila(elemento, null));
    }
  
    public int remover() {
      NoFila primeiro = cabeca.obterProximoNo();
  
      if (primeiro != null)
        cabeca = primeiro;
  
      return primeiro.obterElemento();
    }
  
    public void mostrar() {
      NoFila atual = cabeca;
  
      while (atual.obterProximoNo() != null) {
        atual = atual.obterProximoNo();
        System.out.println(atual.obterElemento());
      }
  
    }
  
    public int calcularAmplitude() {
      NoFila atual = cabeca;
      int maior = Integer.MIN_VALUE, menor = Integer.MAX_VALUE;
  
      while (atual.obterProximoNo() != null) {
        atual = atual.obterProximoNo();
        if (atual.obterElemento() > maior)
          maior = atual.obterElemento();
        if (atual.obterElemento() < menor)
          menor = atual.obterElemento();
      }
  
      return maior - menor;
    }
  
    public double calcularMedia() {
      NoFila atual = cabeca;
      double soma = 0;
      int contador = 0;
  
      while (atual.obterProximoNo() != null) {
        atual = atual.obterProximoNo();
        soma += atual.obterElemento();
        contador++;
      }
  
      return soma / (double) contador;
    }
  
    public void furar(int elemento, int posicao) {
      NoFila anterior = cabeca;
      NoFila proximo = cabeca.obterProximoNo();
      int posicaoAtual = 0;
  
      while (posicaoAtual != posicao && proximo != null) {
        anterior = proximo;
        proximo = proximo.obterProximoNo();
        posicaoAtual++;
      }
  
      NoFila novoNo = new NoFila(elemento, proximo);
      anterior.definirProximoNo(novoNo);
    }
  
    public int obterMenor() {
      if (cabeca.obterProximoNo() == null) throw new RuntimeException("Fila Vazia");
  
      return encontrarMenor(cabeca.obterProximoNo());
    }
  
    private int encontrarMenor(NoFila no) {
      int menor = Integer.MAX_VALUE;
  
      if (no == null)
        return menor;
  
      menor = encontrarMenor(no.obterProximoNo());
  
      return Math.min(no.obterElemento(), menor);
    }
  
    public void inverter() {
      if (cabeca.obterProximoNo() == null)
        return;
  
      NoFila anterior = cabeca;
      anterior.definirProximoNo(null);
      NoFila proximo = cabeca.obterProximoNo();
  
      while (proximo.obterProximoNo() != null) {
  
      }
  
    }
  }
  
  class FilaSemCabeca {
    private NoFila fila;
  
    public FilaSemCabeca() {
      this.fila = null;
    }
  
    public void enfileirar(int elemento) {
      if (fila == null) {
        fila = new NoFila(elemento, null);
        return;
      }
  
      NoFila atual = fila.obterProximoNo();
  
      while (atual.obterProximoNo() != null) atual = atual.obterProximoNo();
  
      atual.definirProximoNo(new NoFila(elemento, null));
    }
  
    public int remover() {
      if (fila == null) throw new RuntimeException("Fila Vazia");
  
      NoFila primeiro = fila;
      fila = fila.obterProximoNo();
  
      return primeiro.obterElemento();
    }
  
    public void mostrar() {
      NoFila atual = fila;
  
      while (atual != null) {
        System.out.println(atual.obterElemento());
        atual = atual.obterProximoNo();
      }
  
    }
  }
