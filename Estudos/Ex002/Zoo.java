package Estudos.Ex002;

public class Zoo {
    public void ouvirAnimais(Animal[] animais) {
        for (int i=0; i<animais.length; i++) {
            try {
                if (animais[i] == null) {
                    throw new NullPointerException("Animal nulo encontrado");
                } else {
                    animais[i].emitirSom();
                }
            } catch (NullPointerException e) {
                System.err.println("Erro ao ouvir animais");
            }

        }
    }
    // "instanceof" é um operador binário que usamos para testar se um objeto é de um determinado tipo. O resultado da operação é um booleano, ou seja, true ou false. Também é conhecido como operador de comparação de tipos porque compara a instâncioa de um objeto com um tipo.
}
