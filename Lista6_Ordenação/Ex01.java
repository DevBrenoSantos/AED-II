package Lista6_Ordenação;

import java.time.InstantSource;
import java.util.Random;

import Lista6_Ordenação.Eficientes.*;
import Lista6_Ordenação.NãoEficientes.*;

@SuppressWarnings("unused")
public class Ex01 {
    public static void main(String[] args) throws InterruptedException{
        // Recursos adicionais
        long start = System.currentTimeMillis();
        // Pausa de 2 segundos
        System.out.println("Iniciando programa");
        Thread.sleep(500);
        System.out.println("1...");
        Thread.sleep(500);
        System.out.println("2...");
        Thread.sleep(500);
        System.out.println("3...");
        Thread.sleep(500);
        // Inicio timer Não Eficientes
        long startTimeIneficientes = System.nanoTime();


        // -------------BUBLLESORT--------------
        double vetBublle[]= gerarAleatorio(10000, 1, 50000);

        // Parte de cálculo do tempo de execução do método de ordenação BublleSort em nanosegundos
        long startTimeBublle = System.nanoTime();
        // Função de ordenação
        BublleSort.bublleSort(vetBublle);
        long endTimeBublle = System.nanoTime();
        long tempoBublle = (endTimeBublle - startTimeBublle) ; 
        
        for(int i=0; i<vetBublle.length; i++){
            System.out.println(vetBublle[i]);
        }

        // Transformando o tempo de nanosegundos para segundos 
        double tempoBublleSeg = tempoBublle*(Math.pow(10, (-9)));

        // -------------SELECTIONSORT--------------
        double vetSelection[] = gerarAleatorio(10000, 1, 50000);

        // Parte de cálculo do tempo de execução do método de ordenação SelectionSort em nanosegundos
        long startTimeSelection = System.nanoTime();
        // Função de ordenação
        SelectionSort.selectionSort(vetSelection);
        long endTimeSelection = System.nanoTime();
        long tempoSelection = (endTimeSelection - startTimeSelection) ; 
        
        for(int i=0; i<vetSelection.length; i++){
            System.out.println(vetSelection[i]);
        }

        // Transformando o tempo de nanosegundos para segundos 
        double tempoSelectionSeg = tempoSelection*(Math.pow(10, (-9)));

        // -------------INSERTSORT--------------
        double vetInsert[] = gerarAleatorio(10000, 1, 50000);

        // Parte de cálculo do tempo de execução do método de ordenação InsertSort em nanosegundos
        long startTimeInsert = System.nanoTime();
        // Função de ordenação
        InsertSort.insertSort(vetInsert);
        long endTimeInsert = System.nanoTime();
        long tempoInsert = (endTimeInsert - startTimeInsert) ; 
        
        for(int i=0; i<vetInsert.length; i++){
            System.out.println(vetInsert[i]);
        }

        // Transformando o tempo de nanosegundos para segundos 
        double tempoInsertSeg = tempoInsert*(Math.pow(10, (-9)));

        // Término do método não eficientes
        long endTimeIneficientes = System.nanoTime();
        long tempoIneficientes = (endTimeIneficientes - startTimeIneficientes);
        double tempoIneficientesSeg = tempoIneficientes*(Math.pow(10, (-9)));

        System.out.println("\nPrimeira parcial, métodos não eficientes: " + tempoIneficientesSeg + " segundos\n");
        Thread.sleep(5000);

        // Inicio timer eficientes
        long startTimeEficientes = System.nanoTime();

        // -------------MERGESORT--------------
        double vetMerge[] = gerarAleatorio(10000, 1, 50000);

        // Parte de cálculo do tempo de execução do método de ordenação InsertSort em nanosegundos
        long startTimeMerge = System.nanoTime();
        // Função de ordenação
        MergeSort.mergeSort(vetMerge);
        long endTimeMerge = System.nanoTime();
        long tempoMerge = (endTimeMerge - startTimeMerge) ; 

        for(int i=0; i<vetMerge.length; i++){
            System.out.println(vetMerge[i]);
        }

        // Transformando o tempo de nanosegundos para segundos 
        double tempoMergeSeg = tempoMerge*(Math.pow(10, (-9)));

        // -------------QUICKSORT--------------
        double vetQuick[] = gerarAleatorio(10000, 1, 50000);

        // Parte de cálculo do tempo de execução do método de ordenação InsertSort em nanosegundos
        long startTimeQuick = System.nanoTime();
        // Função de ordenação
        QuickSort.quickSort(vetQuick, 0, vetQuick.length-1);
        long endTimeQuick = System.nanoTime();
        long tempoQuick = (endTimeQuick - startTimeQuick) ; 

        for(int i=0; i<vetQuick.length; i++){
            System.out.println(vetQuick[i]);
        }

        // Transformando o tempo de nanosegundos para segundos 
        double tempoQuickSeg = tempoQuick*(Math.pow(10, (-9)));
        
        // -------------SHELLSORT--------------
        double vetShell[] = gerarAleatorio(10000, 1, 50000);

        // Parte de cálculo do tempo de execução do método de ordenação InsertSort em nanosegundos
        long startTimeShell = System.nanoTime();
        // Função de ordenação
        Shellsort.shellSort(vetShell);
        long endTimeShell = System.nanoTime();
        long tempoShell = (endTimeShell - startTimeShell) ; 

        for(int i=0; i<vetShell.length; i++){
            System.out.println(vetShell[i]);
        }

        // Transformando o tempo de nanosegundos para segundos 
        double tempoShellSeg = tempoQuick*(Math.pow(10, (-9)));

        // -------------HEAPSORT--------------
        double vetHeap[] = gerarAleatorio(10000, 1, 50000);

        // Parte de cálculo do tempo de execução do método de ordenação InsertSort em nanosegundos
        long startTimeHeap = System.nanoTime();
        // Função de ordenação
        HeapSort.heapSort(vetHeap);
        long endTimeHeap = System.nanoTime();
        long tempoHeap = (endTimeHeap - startTimeHeap) ; 

        for(int i=0; i<vetHeap.length; i++){
            System.out.println(vetHeap[i]);
        }

        // Transformando o tempo de nanosegundos para segundos 
        double tempoHeapSeg = tempoQuick*(Math.pow(10, (-9)));

        // Término do método não eficientes
        long endTimeEficientes = System.nanoTime();
        long tempoEficientes = (endTimeEficientes - startTimeEficientes);
        double tempoEficientesSeg = tempoEficientes*(Math.pow(10, (-9)));

        // Imprimindo o tempo de execução do métodos
        System.out.println("\n----------Tempo de execução dos métodos----------");
        System.out.println("Tempo decorrido BublleSort: " + tempoBublle + " nanosegundos");
        System.out.println("Tempo decorrido BublleSort: " + tempoBublleSeg + " segundos\n");

        System.out.println("Tempo decorrido SelectionSort: " + tempoSelection + " nanosegundos");
        System.out.println("Tempo decorrido SelectionSort: " + tempoSelectionSeg + " segundos\n");

        System.out.println("Tempo decorrido InsertSort: " + tempoInsert + " nanosegundos");
        System.out.println("Tempo decorrido InsertSort: " + tempoInsertSeg + " segundos\n");

        System.out.println("Tempo decorrido MergeSort: " + tempoMerge + " nanosegundos");
        System.out.println("Tempo decorrido MergeSort: " + tempoMergeSeg + " segundos\n");

        System.out.println("Tempo decorrido QuickSort: " + tempoQuick + " nanosegundos");
        System.out.println("Tempo decorrido QuickSort: " + tempoQuickSeg + " segundos\n");

        System.out.println("Tempo decorrido ShellSort: " + tempoShell + " nanosegundos");
        System.out.println("Tempo decorrido ShellSort: " + tempoShellSeg + " segundos\n");

        System.out.println("Tempo decorrido HeapSort: " + tempoHeap + " nanosegundos");
        System.out.println("Tempo decorrido HeapSort: " + tempoHeapSeg + " segundos\n");

        System.out.println("----------Relatório----------");
        System.out.println("Tempo decorrido dos método não eficientes: " + tempoIneficientes + " nanosegundos");
        System.out.println("Tempo decorrido dos método não eficientes: " + tempoIneficientesSeg + " segundos\n");

        System.out.println("Tempo decorrido dos método eficientes: " + tempoEficientes + " nanosegundos");
        System.out.println("Tempo decorrido dos método eficientes: " + tempoEficientesSeg + " segundos\n");
    }

    public static double[] gerarAleatorio(int tamanho, double minimo, double maximo) {
        double[] vetorAleatorio = new double[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            vetorAleatorio[i] = minimo + (maximo - minimo) * random.nextDouble(); // valores dentro do intervaloz
        }

        return vetorAleatorio;
    }

}
