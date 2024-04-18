package Lista6_Ordenação;

import java.util.Random;
import java.util.Scanner;

import Lista6_Ordenação.Cores;
import Lista6_Ordenação.Eficientes.*;
import Lista6_Ordenação.NãoEficientes.*;
@SuppressWarnings("unused")
public class Ex01 {
    // Variáveis globais
    public static double tempoBublle, tempoBublleSeg;
    public static double tempoInsert, tempoInsertSeg;
    public static double tempoSelection, tempoSelectionSeg;
    public static double tempoHeap, tempoHeapSeg;
    public static double tempoMerge, tempoMergeSeg;
    public static double tempoQuick, tempoQuickSeg;
    public static double tempoShell, tempoShellSeg;

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        String continuar = "";
        int opc;
        do {
            System.out.println(Cores.GREEN_BOLD_BRIGHT + "----------Menu de Métodos de Ordenação----------" + Cores.RESET);
            System.out.println(Cores.BLUE_BOLD_BRIGHT + "1 - BublleSort\n2 - SelectionSort\n3 - InsertSort\n4 - MergeSort\n5 - QuickSort\n6 - ShellSort\n7 - HeapSort\n8 - Comparar métodos eficientes e não eficientes" + Cores.RESET);

            opc = input.nextInt();

            menuMetodos(opc);

            System.out.println(Cores.YELLOW_BACKGROUND + "Deseja continuar? (s/n)" + Cores.RESET);
            input.nextLine();
            continuar = input.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        System.out.println(Cores.RED + "Programa finalizado" + Cores.RESET);

        input.close();
    }

    public static void menuMetodos(int opcao) throws InterruptedException {
        switch (opcao) {
            case 1:
                rodarBubble();
                break;
        
            case 2:
                rodarSelection();
                break;

            case 3:
                rodarInsert();
                break;

            case 4:
                rodarMerge();
                break;

            case 5:
                rodarQuick();
                break;

            case 6:
                rodarShell();
                break;

            case 7:
                rodarHeap();
                break;
            
            case 8:

                // Recursos adicionais
                long start = System.currentTimeMillis();

                // Inicio timer Não Eficientes
                long startTimeIneficientes = System.nanoTime();

                menuMetodos(1);
                menuMetodos(2);
                menuMetodos(3);

                // Término do método não eficientes
                long endTimeIneficientes = System.nanoTime();
                long tempoIneficientes = (endTimeIneficientes - startTimeIneficientes);
                double tempoIneficientesSeg = tempoIneficientes*(Math.pow(10, (-9)));

                // Inicio timer eficientes
                long startTimeEficientes = System.nanoTime();

                menuMetodos(4);
                menuMetodos(5);
                menuMetodos(6);
                menuMetodos(7);

                // Término do método eficientes
                long endTimeEficientes = System.nanoTime();
                long tempoEficientes = (endTimeEficientes - startTimeEficientes);
                double tempoEficientesSeg = tempoEficientes*(Math.pow(10, (-9)));

                System.out.println(Cores.GREEN + "----------Relatório----------" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo decorrido dos método não eficientes: "+ Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoIneficientes + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo decorrido dos método não eficientes: "+ Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoIneficientesSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo decorrido dos método eficientes: "+ Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoEficientes + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo decorrido dos método eficientes: "+ Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoEficientesSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);

                System.out.println(Cores.GREEN + "----------Tempos indivuduais----------" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo BublleSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoBublle + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos"+ Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo BublleSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoBublleSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n"+ Cores.RESET);

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo InsertSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoInsert + Cores.RESET + Cores.BLUE_BOLD_BRIGHT +" nanosegundos"+ Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo InsertSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoInsertSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n"+ Cores.RESET);

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo SelectionSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoSelection + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos"+ Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo SelectionSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoSelectionSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n"+ Cores.RESET);

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo MergeSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoMerge + Cores.RESET + Cores.BLUE_BOLD_BRIGHT +" nanosegundos"+ Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo MergeSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoMergeSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT +" segundos\n"+ Cores.RESET);

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo QuickSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoQuick + Cores.RESET + Cores.BLUE_BOLD_BRIGHT +" nanosegundos"+ Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo QuickSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoQuickSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT +" segundos\n"+ Cores.RESET);

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo ShellSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoShell + Cores.RESET + Cores.BLUE_BOLD_BRIGHT +" nanosegundos"+ Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo ShellSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoShellSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT +" segundos\n"+ Cores.RESET);

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo HeapSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoHeap + Cores.RESET + Cores.BLUE_BOLD_BRIGHT +" nanosegundos"+ Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo HeapSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT + tempoHeapSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n"+ Cores.RESET);
                break;

            default:
                    System.err.println(Cores.RED + "Opção inválida" + Cores.RESET);
                break;
        }
    }

    public static double[] gerarAleatorio(int tamanho, double minimo, double maximo) {
        double[] vetorAleatorio = new double[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            vetorAleatorio[i] = minimo + (maximo - minimo) * random.nextDouble(); // valores dentro do intervaloz
        }

        return vetorAleatorio;
    }

    public static void rodarBubble() throws InterruptedException {
        System.out.println(Cores.PURPLE + "BublleSort" + Cores.RESET);
        Thread.sleep(3000);
        // -------------BUBLLESORT--------------
        double vetBublle[]= gerarAleatorio(10000, 1, 50000);

        // Parte de cálculo do tempo de execução do método de ordenação BublleSort em nanosegundos
        long startTimeBublle = System.nanoTime();
        // Função de ordenação
        BublleSort.bublleSort(vetBublle);
        long endTimeBublle = System.nanoTime();
        tempoBublle = (endTimeBublle - startTimeBublle) ; 
        
        for(int i=0; i<vetBublle.length; i++){
            System.out.println(vetBublle[i]);
        }

        // Transformando o tempo de nanosegundos para segundos 
        tempoBublleSeg = tempoBublle*(Math.pow(10, (-9)));

        System.out.println("Tempo decorrido BublleSort: " + tempoBublle + " nanosegundos");
        System.out.println("Tempo decorrido BublleSort: " + tempoBublleSeg + " segundos\n");
    }

    public static void rodarInsert() throws InterruptedException {
        System.out.println(Cores.PURPLE + "InsertSort" + Cores.RESET);
        Thread.sleep(3000);
        // -------------INSERTSORT--------------
        double vetInsert[] = gerarAleatorio(10000, 1, 50000);

        // Parte de cálculo do tempo de execução do método de ordenação InsertSort em nanosegundos
        long startTimeInsert = System.nanoTime();
        // Função de ordenação
        InsertSort.insertSort(vetInsert);
        long endTimeInsert = System.nanoTime();
        tempoInsert = (endTimeInsert - startTimeInsert) ; 

        for(int i=0; i<vetInsert.length; i++){
            System.out.println(vetInsert[i]);
        }

        // Transformando o tempo de nanosegundos para segundos 
        tempoInsertSeg = tempoInsert*(Math.pow(10, (-9)));

        System.out.println("Tempo decorrido InsertSort: " + tempoInsert + " nanosegundos");
        System.out.println("Tempo decorrido InsertSort: " + tempoInsertSeg + " segundos\n");
    }

    public static void rodarSelection() throws InterruptedException {
        System.out.println(Cores.PURPLE + "SelectionSort" + Cores.RESET);
        Thread.sleep(3000);
        // -------------SELECTIONSORT--------------
        double vetSelection[] = gerarAleatorio(10000, 1, 50000);

        // Parte de cálculo do tempo de execução do método de ordenação SelectionSort em nanosegundos
        long startTimeSelection = System.nanoTime();
        // Função de ordenação
        SelectionSort.selectionSort(vetSelection);
        long endTimeSelection = System.nanoTime();
        tempoSelection = (endTimeSelection - startTimeSelection) ; 
        
        for(int i=0; i<vetSelection.length; i++){
            System.out.println(vetSelection[i]);
        }

        // Transformando o tempo de nanosegundos para segundos 
        tempoSelectionSeg = tempoSelection*(Math.pow(10, (-9)));

        System.out.println("Tempo decorrido SelectionSort: " + tempoSelection + " nanosegundos");
        System.out.println("Tempo decorrido SelectionSort: " + tempoSelectionSeg + " segundos\n");
    }
    
    public static void rodarHeap() throws InterruptedException {
        System.out.println(Cores.PURPLE + "HeapSort" + Cores.RESET);
        Thread.sleep(3000);
        // -------------HEAPSORT--------------
        double vetHeap[] = gerarAleatorio(10000, 1, 50000);

        // Parte de cálculo do tempo de execução do método de ordenação InsertSort em nanosegundos
        long startTimeHeap = System.nanoTime();
        // Função de ordenação
        HeapSort.heapSort(vetHeap);
        long endTimeHeap = System.nanoTime();
        tempoHeap = (endTimeHeap - startTimeHeap) ; 

        for(int i=0; i<vetHeap.length; i++){
            System.out.println(vetHeap[i]);
        }

        // Transformando o tempo de nanosegundos para segundos 
        tempoHeapSeg = tempoHeap*(Math.pow(10, (-9)));

        System.out.println("Tempo decorrido HeapSort: " + tempoHeap + " nanosegundos");
        System.out.println("Tempo decorrido HeapSort: " + tempoHeapSeg + " segundos\n");
    }

    public static void rodarMerge() throws InterruptedException {
        System.out.println(Cores.PURPLE + "MergeSort" + Cores.RESET);
        Thread.sleep(3000);
        // -------------MERGESORT--------------
        double vetMerge[] = gerarAleatorio(10000, 1, 50000);

        // Parte de cálculo do tempo de execução do método de ordenação InsertSort em nanosegundos
        long startTimeMerge = System.nanoTime();
        // Função de ordenação
        MergeSort.mergeSort(vetMerge);
        long endTimeMerge = System.nanoTime();
        tempoMerge = (endTimeMerge - startTimeMerge) ; 

        for(int i=0; i<vetMerge.length; i++){
            System.out.println(vetMerge[i]);
        }

        // Transformando o tempo de nanosegundos para segundos 
        tempoMergeSeg = tempoMerge*(Math.pow(10, (-9)));

        System.out.println("Tempo decorrido MergeSort: " + tempoMerge + " nanosegundos");
        System.out.println("Tempo decorrido MergeSort: " + tempoMergeSeg + " segundos\n");
    }

    public static void rodarQuick() throws InterruptedException {
        System.out.println(Cores.PURPLE + "QuickSort" + Cores.RESET);
        Thread.sleep(3000);
        // -------------QUICKSORT--------------
        double vetQuick[] = gerarAleatorio(10000, 1, 50000);

        // Parte de cálculo do tempo de execução do método de ordenação InsertSort em nanosegundos
        long startTimeQuick = System.nanoTime();
        // Função de ordenação
        QuickSort.quickSort(vetQuick, 0, vetQuick.length-1);
        long endTimeQuick = System.nanoTime();
        tempoQuick = (endTimeQuick - startTimeQuick) ; 

        for(int i=0; i<vetQuick.length; i++){
            System.out.println(vetQuick[i]);
        }

        // Transformando o tempo de nanosegundos para segundos 
        tempoQuickSeg = tempoQuick*(Math.pow(10, (-9)));

        System.out.println("Tempo decorrido QuickSort: " + tempoQuick + " nanosegundos");
        System.out.println("Tempo decorrido QuickSort: " + tempoQuickSeg + " segundos\n");
    }

    public static void rodarShell() throws InterruptedException {
        System.out.println(Cores.PURPLE + "ShellSort" + Cores.RESET);
        Thread.sleep(3000);
        // -------------SHELLSORT--------------
        double vetShell[] = gerarAleatorio(10000, 1, 50000);

        // Parte de cálculo do tempo de execução do método de ordenação InsertSort em nanosegundos
        long startTimeShell = System.nanoTime();
        // Função de ordenação
        Shellsort.shellSort(vetShell);
        long endTimeShell = System.nanoTime();
        tempoShell = (endTimeShell - startTimeShell) ; 

        for(int i=0; i<vetShell.length; i++){
            System.out.println(vetShell[i]);
        }

        // Transformando o tempo de nanosegundos para segundos 
        tempoShellSeg = tempoShell*(Math.pow(10, (-9)));

        System.out.println("Tempo decorrido ShellSort: " + tempoShell + " nanosegundos");
        System.out.println("Tempo decorrido ShellSort: " + tempoShellSeg + " segundos\n");
    }
}