package Lista6_Ordenação;

import java.util.Random;
import java.util.Scanner;

import Lista6_Ordenação.Cores;
import Lista6_Ordenação.Eficientes.*;
import Lista6_Ordenação.NãoEficientes.*;

@SuppressWarnings("unused")
public class Ex01 {
    // Variáveis globais
    public static double tempoBubble, tempoBubbleSeg;
    public static double tempoInsert, tempoInsertSeg;
    public static double tempoSelection, tempoSelectionSeg;
    public static double tempoHeap, tempoHeapSeg;
    public static double tempoMerge, tempoMergeSeg;
    public static double tempoQuick, tempoQuickSeg;
    public static double tempoShell, tempoShellSeg;
    public static int tamanhoVetor = 0, opcOrdem = 0;

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        String continuar = "s", testeContinue;
        int opc, opcOrdenado;
        try {
            System.out.println(Cores.PURPLE_BOLD_BRIGHT + "Deseja testar em um vetor ordenado? (s/n)" + Cores.RESET);
            String ordenado = input.next();
            if (ordenado.equalsIgnoreCase("s")) {
                throw new ExcecaoOrdenado("Vetor ordenado");
            }
        } catch (ExcecaoOrdenado e) {
            do {
                if (tamanhoVetor == 0) {
                    System.out.println(Cores.PURPLE_BOLD_BRIGHT + "Insira o tamanho do vetor ordenado: " + Cores.RESET);
                    tamanhoVetor = input.nextInt();
                } else {
                    System.out.println(Cores.PURPLE_BOLD_BRIGHT
                            + "Deseja testar em um vetor de tamanho diferente? (s/n)" + Cores.RESET);
                    String teste = input.next();
                    if (teste.equalsIgnoreCase("s")) {
                        System.out.println(Cores.PURPLE_BOLD_BRIGHT + "Insira o tamanho do vetor: " + Cores.RESET);
                        tamanhoVetor = input.nextInt();
                    }
                }
                double vetRaiz[] = gerarAleatorio(tamanhoVetor, 1, 50000);
                HeapSort.heapSort(vetRaiz);
                System.out.println(Cores.GREEN_BOLD_BRIGHT
                        + "----------Deseja testar em qual método de ordenação?----------" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT
                        + "1 - BubbleSort\n2 - SelectionSort\n3 - InsertSort\n4 - MergeSort\n5 - QuickSort\n6 - ShellSort\n7 - HeapSort"
                        + Cores.RESET);
                opcOrdenado = input.nextInt();
                menuMetodosParaOrdenados(opcOrdenado, vetRaiz);
                System.out.println(Cores.YELLOW_BACKGROUND
                        + "Deseja continuar testando em vetores ordenados, sair ou testar em outros vetores? ('continuar'/'sair'/'testar')"
                        + Cores.RESET);
                input.nextLine();
                testeContinue = input.nextLine();

                if (testeContinue.equalsIgnoreCase("Sair")) {
                    System.out.println(Cores.RED_BACKGROUND_BRIGHT + "Programa finalizado" + Cores.RESET);
                    System.exit(0);
                }
            } while (testeContinue.equalsIgnoreCase("continuar"));
        }

        do {
            if (tamanhoVetor != 0) {
                System.out.println(Cores.PURPLE_BOLD_BRIGHT + "Deseja testar em um vetor de tamanho diferente? (s/n)"
                        + Cores.RESET);
                String teste = input.next();
                if (teste.equalsIgnoreCase("s")) {
                    System.out.println(Cores.PURPLE_BOLD_BRIGHT + "Insira o tamanho do vetor: " + Cores.RESET);
                    tamanhoVetor = input.nextInt();
                }
            }
            System.out.println(
                    Cores.GREEN_BOLD_BRIGHT + "----------Menu de Métodos de Ordenação----------" + Cores.RESET);
            System.out.println(Cores.BLUE_BOLD_BRIGHT
                    + "1 - BubbleSort\n2 - SelectionSort\n3 - InsertSort\n4 - MergeSort\n5 - QuickSort\n6 - ShellSort\n7 - HeapSort\n8 - Comparar métodos eficientes e não eficientes"
                    + Cores.RESET);

            opc = input.nextInt();
            menuMetodos(opc);

            System.out.println(Cores.YELLOW_BACKGROUND + "Deseja continuar? (s/n)" + Cores.RESET);
            input.nextLine();

            continuar = input.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        System.out.println(Cores.RED_BACKGROUND_BRIGHT + "Programa finalizado" + Cores.RESET);

        input.close();
    }

    public static void menuMetodosParaOrdenados(int opcao, double[] vetOrdenado) throws InterruptedException {
        switch (opcao) {
            case 1:
                long startTimeBubble = System.nanoTime();
                BubbleSort.bubbleSort(vetOrdenado);
                long endTimeBubble = System.nanoTime();
                tempoBubble = (endTimeBubble - startTimeBubble);

                // Transformando o tempo de nanosegundos para segundos
                tempoBubbleSeg = tempoBubble * (Math.pow(10, (-9)));

                System.out
                        .println(Cores.BLUE_BOLD_BRIGHT + "Tempo BubbleSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                                + tempoBubble + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
                System.out
                        .println(Cores.BLUE_BOLD_BRIGHT + "Tempo BubbleSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                                + tempoBubbleSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);
                break;
            case 2:
                long startTimeInsert = System.nanoTime();
                InsertSort.insertSort(vetOrdenado);
                long endTimeInsert = System.nanoTime();
                tempoInsert = (endTimeInsert - startTimeInsert);

                // Transformando o tempo de nanosegundos para segundos
                tempoInsertSeg = tempoInsert * (Math.pow(10, (-9)));

                System.out
                        .println(Cores.BLUE_BOLD_BRIGHT + "Tempo InsertSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                                + tempoInsert + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
                System.out
                        .println(Cores.BLUE_BOLD_BRIGHT + "Tempo InsertSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                                + tempoInsertSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);
                break;
            case 3:
                long startTimeSelection = System.nanoTime();
                SelectionSort.selectionSort(vetOrdenado);
                long endTimeSelection = System.nanoTime();
                tempoSelection = (endTimeSelection - startTimeSelection);

                // Transformando o tempo de nanosegundos para segundos
                tempoSelectionSeg = tempoSelection * (Math.pow(10, (-9)));

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo SelectionSort: " + Cores.RESET
                        + Cores.YELLOW_BOLD_BRIGHT + tempoSelection + Cores.RESET + Cores.BLUE_BOLD_BRIGHT
                        + " nanosegundos" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo SelectionSort: " + Cores.RESET
                        + Cores.YELLOW_BOLD_BRIGHT + tempoSelectionSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT
                        + " segundos\n" + Cores.RESET);
                break;
            case 4:
                long startTimeMerge = System.nanoTime();
                MergeSort.mergeSort(vetOrdenado);
                long endTimeMerge = System.nanoTime();
                tempoMerge = (endTimeMerge - startTimeMerge);

                // Transformando o tempo de nanosegundos para segundos
                tempoMergeSeg = tempoMerge * (Math.pow(10, (-9)));

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo MergeSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoMerge + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo MergeSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoMergeSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);
                break;
            case 5:
                long startTimeQuick = System.nanoTime();
                QuickSort.quickSort(vetOrdenado, 0, vetOrdenado.length - 1);
                long endTimeQuick = System.nanoTime();
                tempoQuick = (endTimeQuick - startTimeQuick);

                // Transformando o tempo de nanosegundos para segundos
                tempoQuickSeg = tempoQuick * (Math.pow(10, (-9)));

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo QuickSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoQuick + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo QuickSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoQuickSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);
                break;
            case 6:
                long startTimeShell = System.nanoTime();
                Shellsort.shellSort(vetOrdenado);
                long endTimeShell = System.nanoTime();
                tempoShell = (endTimeShell - startTimeShell);

                // Transformando o tempo de nanosegundos para segundos
                tempoShellSeg = tempoShell * (Math.pow(10, (-9)));

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo ShellSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoShell + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo ShellSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoShellSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);
                break;
            case 7:
                long startTimeHeap = System.nanoTime();
                HeapSort.heapSort(vetOrdenado);
                long endTimeHeap = System.nanoTime();
                tempoHeap = (endTimeHeap - startTimeHeap);

                // Transformando o tempo de nanosegundos para segundos
                tempoHeapSeg = tempoHeap * (Math.pow(10, (-9)));

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo HeapSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoHeap + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo HeapSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoHeapSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);
                break;
            default:
                System.out.println(Cores.RED + "Opção inválida" + Cores.RESET);
                break;
        }
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
                double tempoIneficientesSeg = tempoIneficientes * (Math.pow(10, (-9)));

                // Inicio timer eficientes
                long startTimeEficientes = System.nanoTime();

                menuMetodos(4);
                menuMetodos(5);
                menuMetodos(6);
                menuMetodos(7);

                // Término do método eficientes
                long endTimeEficientes = System.nanoTime();
                long tempoEficientes = (endTimeEficientes - startTimeEficientes);
                double tempoEficientesSeg = tempoEficientes * (Math.pow(10, (-9)));

                System.out.println(Cores.GREEN + "----------Relatório----------" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo decorrido dos métodos não eficientes: " + Cores.RESET
                        + Cores.YELLOW_BOLD_BRIGHT + tempoIneficientes + Cores.RESET + Cores.BLUE_BOLD_BRIGHT
                        + " nanosegundos" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo decorrido dos métodos não eficientes: " + Cores.RESET
                        + Cores.YELLOW_BOLD_BRIGHT + tempoIneficientesSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT
                        + " segundos\n" + Cores.RESET);

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo decorrido dos métodos eficientes: " + Cores.RESET
                        + Cores.YELLOW_BOLD_BRIGHT + tempoEficientes + Cores.RESET + Cores.BLUE_BOLD_BRIGHT
                        + " nanosegundos" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo decorrido dos métodos eficientes: " + Cores.RESET
                        + Cores.YELLOW_BOLD_BRIGHT + tempoEficientesSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT
                        + " segundos\n" + Cores.RESET);

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo médio dos métodos não eficientes: " + Cores.RESET
                        + Cores.YELLOW_BOLD_BRIGHT + (tempoIneficientes / 3) + Cores.RESET + Cores.BLUE_BOLD_BRIGHT
                        + " nanosegundos" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo médio dos métodos não eficientes: " + Cores.RESET
                        + Cores.YELLOW_BOLD_BRIGHT + (tempoIneficientesSeg / 3) + Cores.RESET + Cores.BLUE_BOLD_BRIGHT
                        + " segundos\n" + Cores.RESET);

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo médio dos métodos eficientes: " + Cores.RESET
                        + Cores.YELLOW_BOLD_BRIGHT + (tempoEficientes / 4) + Cores.RESET + Cores.BLUE_BOLD_BRIGHT
                        + " nanosegundos" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo médio dos métodos eficientes: " + Cores.RESET
                        + Cores.YELLOW_BOLD_BRIGHT + (tempoEficientesSeg / 4) + Cores.RESET + Cores.BLUE_BOLD_BRIGHT
                        + " segundos\n" + Cores.RESET);

                System.out.println(Cores.GREEN + "----------Tempos indivuduais----------" + Cores.RESET);
                System.out
                        .println(Cores.BLUE_BOLD_BRIGHT + "Tempo BubbleSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                                + tempoBubble + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
                System.out
                        .println(Cores.BLUE_BOLD_BRIGHT + "Tempo BubbleSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                                + tempoBubbleSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);

                System.out
                        .println(Cores.BLUE_BOLD_BRIGHT + "Tempo InsertSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                                + tempoInsert + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
                System.out
                        .println(Cores.BLUE_BOLD_BRIGHT + "Tempo InsertSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                                + tempoInsertSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo SelectionSort: " + Cores.RESET
                        + Cores.YELLOW_BOLD_BRIGHT + tempoSelection + Cores.RESET + Cores.BLUE_BOLD_BRIGHT
                        + " nanosegundos" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo SelectionSort: " + Cores.RESET
                        + Cores.YELLOW_BOLD_BRIGHT + tempoSelectionSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT
                        + " segundos\n" + Cores.RESET);

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo MergeSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoMerge + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo MergeSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoMergeSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo QuickSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoQuick + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo QuickSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoQuickSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo ShellSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoShell + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo ShellSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoShellSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);

                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo HeapSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoHeap + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
                System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo HeapSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoHeapSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);
                break;

            default:
                System.err.println(Cores.RED + "Opção inválida" + Cores.RESET);
                break;
        }
    }

    // Método para gerar um vetor decrescente com aleatorização da parte fracionada
    public static double[] gerarDecrescenteAleatorio(int tamanho) {
        double[] vetorDecrescenteAleatorio = new double[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            double valor = tamanho - i; // gera o valor decrescente

            // Aleatoriza a parte fracionada
            double parteFracionadaAleatoria = random.nextDouble();
            valor += parteFracionadaAleatoria;

            vetorDecrescenteAleatorio[i] = valor;
        }

        return vetorDecrescenteAleatorio;
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
        System.out.println(Cores.PURPLE + "BubbleSort" + Cores.RESET);
        // -------------BUBBLESORT--------------
        if (tamanhoVetor == 0) {
            System.out.println("Digite o tamanho do vetor: ");
            tamanhoVetor = input.nextInt();
        }
        double vetBubble[] = null;

        // Escolha do tipo de vetor
        if (opcOrdem == 0) {
            System.out.println("Deseja ordenar em qual ordem? (1 - Aleatório, 2 - Decrescente)");
            opcOrdem = input.nextInt();
        }

        if (opcOrdem != 1 && opcOrdem != 2) {
            System.err.println(Cores.RED + "Opção inválida" + Cores.RESET);
            return;
        }

        if (opcOrdem == 1) {
            vetBubble = gerarAleatorio(tamanhoVetor, 1, 50000);
        } else {
            vetBubble = gerarDecrescenteAleatorio(tamanhoVetor);
        }

        // Parte de cálculo do tempo de execução do método de ordenação BubbleSort em
        // nanosegundos
        long startTimeBubble = System.nanoTime();
        // Função de ordenação
        BubbleSort.bubbleSort(vetBubble);
        long endTimeBubble = System.nanoTime();
        tempoBubble = (endTimeBubble - startTimeBubble);

        // Transformando o tempo de nanosegundos para segundos
        tempoBubbleSeg = tempoBubble * (Math.pow(10, (-9)));

        System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo BubbleSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                + tempoBubble + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
        System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo BubbleSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                + tempoBubbleSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);
    }

    public static void rodarInsert() throws InterruptedException {
        System.out.println(Cores.PURPLE + "InsertSort" + Cores.RESET);
        // -------------INSERTSORT--------------
        if (tamanhoVetor == 0) {
            System.out.println("Digite o tamanho do vetor: ");
            tamanhoVetor = input.nextInt();
        }

        double vetInsert[] = null;

        // Escolha do tipo de vetor
        if (opcOrdem == 0) {
            System.out.println("Deseja ordenar em qual ordem? (1 - Aleatório, 2 - Decrescente)");
            opcOrdem = input.nextInt();
        }

        if (opcOrdem != 1 && opcOrdem != 2) {
            System.err.println(Cores.RED + "Opção inválida" + Cores.RESET);
            return;
        }

        if (opcOrdem == 1) {
            vetInsert = gerarAleatorio(tamanhoVetor, 1, 50000);
        } else {
            vetInsert = gerarDecrescenteAleatorio(tamanhoVetor);
        }

        // Parte de cálculo do tempo de execução do método de ordenação InsertSort em
        // nanosegundos
        long startTimeInsert = System.nanoTime();
        // Função de ordenação
        InsertSort.insertSort(vetInsert);
        long endTimeInsert = System.nanoTime();
        tempoInsert = (endTimeInsert - startTimeInsert);

        // Transformando o tempo de nanosegundos para segundos
        tempoInsertSeg = tempoInsert * (Math.pow(10, (-9)));

        System.out
                .println(Cores.BLUE_BOLD_BRIGHT + "Tempo InsertSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoInsert + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
        System.out
                .println(Cores.BLUE_BOLD_BRIGHT + "Tempo InsertSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                        + tempoInsertSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);
    }

    public static void rodarSelection() throws InterruptedException {
        System.out.println(Cores.PURPLE + "SelectionSort" + Cores.RESET);
        // -------------SELECTIONSORT--------------
        if (tamanhoVetor == 0) {
            System.out.println("Digite o tamanho do vetor: ");
            tamanhoVetor = input.nextInt();
        }

        double vetSelection[] = null;

        // Escolha do tipo de vetor
        if (opcOrdem == 0) {
            System.out.println("Deseja ordenar em qual ordem? (1 - Aleatório, 2 - Decrescente)");
            opcOrdem = input.nextInt();
        }

        if (opcOrdem != 1 && opcOrdem != 2) {
            System.err.println(Cores.RED + "Opção inválida" + Cores.RESET);
            return;
        }

        if (opcOrdem == 1) {
            vetSelection = gerarAleatorio(tamanhoVetor, 1, 50000);
        } else {
            vetSelection = gerarDecrescenteAleatorio(tamanhoVetor);
        }

        // Parte de cálculo do tempo de execução do método de ordenação SelectionSort em
        // nanosegundos
        long startTimeSelection = System.nanoTime();
        // Função de ordenação
        SelectionSort.selectionSort(vetSelection);
        long endTimeSelection = System.nanoTime();
        tempoSelection = (endTimeSelection - startTimeSelection);

        // Transformando o tempo de nanosegundos para segundos
        tempoSelectionSeg = tempoSelection * (Math.pow(10, (-9)));

        System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo SelectionSort: " + Cores.RESET
                + Cores.YELLOW_BOLD_BRIGHT + tempoSelection + Cores.RESET + Cores.BLUE_BOLD_BRIGHT
                + " nanosegundos" + Cores.RESET);
        System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo SelectionSort: " + Cores.RESET
                + Cores.YELLOW_BOLD_BRIGHT + tempoSelectionSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT
                + " segundos\n" + Cores.RESET);
    }

    public static void rodarHeap() throws InterruptedException {
        System.out.println(Cores.PURPLE + "HeapSort" + Cores.RESET);
        // -------------HEAPSORT--------------
        if (tamanhoVetor == 0) {
            System.out.println("Digite o tamanho do vetor: ");
            tamanhoVetor = input.nextInt();
        }

        double vetHeap[] = null;

        // Escolha do tipo de vetor
        if (opcOrdem == 0) {
            System.out.println("Deseja ordenar em qual ordem? (1 - Aleatório, 2 - Decrescente)");
            opcOrdem = input.nextInt();
        }

        if (opcOrdem != 1 && opcOrdem != 2) {
            System.err.println(Cores.RED + "Opção inválida" + Cores.RESET);
            return;
        }

        if (opcOrdem == 1) {
            vetHeap = gerarAleatorio(tamanhoVetor, 1, 50000);
        } else {
            vetHeap = gerarDecrescenteAleatorio(tamanhoVetor);
        }

        // Parte de cálculo do tempo de execução do método de ordenação InsertSort em
        // nanosegundos
        long startTimeHeap = System.nanoTime();
        // Função de ordenação
        HeapSort.heapSort(vetHeap);
        long endTimeHeap = System.nanoTime();
        tempoHeap = (endTimeHeap - startTimeHeap);

        // Transformando o tempo de nanosegundos para segundos
        tempoHeapSeg = tempoHeap * (Math.pow(10, (-9)));

        System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo HeapSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                + tempoHeap + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
        System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo HeapSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                + tempoHeapSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);
    }

    public static void rodarMerge() throws InterruptedException {
        System.out.println(Cores.PURPLE + "MergeSort" + Cores.RESET);
        // -------------MERGESORT--------------
        if (tamanhoVetor == 0) {
            System.out.println("Digite o tamanho do vetor: ");
            tamanhoVetor = input.nextInt();
        }

        double vetMerge[] = null;

        // Escolha do tipo de vetor
        if (opcOrdem == 0) {
            System.out.println("Deseja ordenar em qual ordem? (1 - Aleatório, 2 - Decrescente)");
            opcOrdem = input.nextInt();
        }

        if (opcOrdem != 1 && opcOrdem != 2) {
            System.err.println(Cores.RED + "Opção inválida" + Cores.RESET);
            return;
        }

        if (opcOrdem == 1) {
            vetMerge = gerarAleatorio(tamanhoVetor, 1, 50000);
        } else {
            vetMerge = gerarDecrescenteAleatorio(tamanhoVetor);
        }

        // Parte de cálculo do tempo de execução do método de ordenação InsertSort em
        // nanosegundos
        long startTimeMerge = System.nanoTime();
        // Função de ordenação
        MergeSort.mergeSort(vetMerge);
        long endTimeMerge = System.nanoTime();
        tempoMerge = (endTimeMerge - startTimeMerge);

        // Transformando o tempo de nanosegundos para segundos
        tempoMergeSeg = tempoMerge * (Math.pow(10, (-9)));

        System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo MergeSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                + tempoMerge + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
        System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo MergeSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                + tempoMergeSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);
    }

    public static void rodarQuick() throws InterruptedException {
        System.out.println(Cores.PURPLE + "QuickSort" + Cores.RESET);
        // -------------QUICKSORT--------------
        if (tamanhoVetor == 0) {
            System.out.println("Digite o tamanho do vetor: ");
            tamanhoVetor = input.nextInt();
        }

        double vetQuick[] = null;

        // Escolha do tipo de vetor
        if (opcOrdem == 0) {
            System.out.println("Deseja ordenar em qual ordem? (1 - Aleatório, 2 - Decrescente)");
            opcOrdem = input.nextInt();
        }

        if (opcOrdem != 1 && opcOrdem != 2) {
            System.err.println(Cores.RED + "Opção inválida" + Cores.RESET);
            return;
        }

        if (opcOrdem == 1) {
            vetQuick = gerarAleatorio(tamanhoVetor, 1, 50000);
        } else {
            vetQuick = gerarDecrescenteAleatorio(tamanhoVetor);
        }

        // Parte de cálculo do tempo de execução do método de ordenação InsertSort em
        // nanosegundos
        long startTimeQuick = System.nanoTime();
        // Função de ordenação
        QuickSort.quickSort(vetQuick, 0, vetQuick.length - 1);
        long endTimeQuick = System.nanoTime();
        tempoQuick = (endTimeQuick - startTimeQuick);

        // Transformando o tempo de nanosegundos para segundos
        tempoQuickSeg = tempoQuick * (Math.pow(10, (-9)));

        System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo QuickSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                + tempoQuick + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
        System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo QuickSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                + tempoQuickSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);
    }

    public static void rodarShell() throws InterruptedException {
        System.out.println(Cores.PURPLE + "ShellSort" + Cores.RESET);
        // -------------SHELLSORT--------------
        if (tamanhoVetor == 0) {
            System.out.println("Digite o tamanho do vetor: ");
            tamanhoVetor = input.nextInt();
        }

        double vetShell[] = null;

        // Escolha do tipo de vetor
        if (opcOrdem == 0) {
            System.out.println("Deseja ordenar em qual ordem? (1 - Aleatório, 2 - Decrescente)");
            opcOrdem = input.nextInt();
        }

        if (opcOrdem != 1 && opcOrdem != 2) {
            System.err.println(Cores.RED + "Opção inválida" + Cores.RESET);
            return;
        }

        if (opcOrdem == 1) {
            vetShell = gerarAleatorio(tamanhoVetor, 1, 50000);
        } else {
            vetShell = gerarDecrescenteAleatorio(tamanhoVetor);
        }

        // Parte de cálculo do tempo de execução do método de ordenação InsertSort em
        // nanosegundos
        long startTimeShell = System.nanoTime();
        // Função de ordenação
        Shellsort.shellSort(vetShell);
        long endTimeShell = System.nanoTime();
        tempoShell = (endTimeShell - startTimeShell);

        // Transformando o tempo de nanosegundos para segundos
        tempoShellSeg = tempoShell * (Math.pow(10, (-9)));

        System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo ShellSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                + tempoShell + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " nanosegundos" + Cores.RESET);
        System.out.println(Cores.BLUE_BOLD_BRIGHT + "Tempo ShellSort: " + Cores.RESET + Cores.YELLOW_BOLD_BRIGHT
                + tempoShellSeg + Cores.RESET + Cores.BLUE_BOLD_BRIGHT + " segundos\n" + Cores.RESET);
    }
}