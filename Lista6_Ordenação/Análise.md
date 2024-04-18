# Análise de Algoritmos de Ordenação
***Resultado obtidos*:**
- ## **Vetor já ordenado**: 
Todos os algoritmos apresentam tempos muito baixos devido ao vetor já estar ordenado.
O Bubble Sort, Insertion Sort e Shell Sort, que têm complexidade quadrática no pior caso, apresentam tempos menores, como era esperado.
Algoritmos mais eficientes como o Merge Sort, Quick Sort e Heap Sort também apresentam tempos baixos, mas com diferenças significativas em relação aos algoritmos de complexidade quadrática. 
- ## **Vetor em ordem aleatória**:
O Bubble Sort tem um desempenho muito ruim, como esperado, devido à sua complexidade quadrática.
Algoritmos como Quick Sort, Merge Sort e Heap Sort, que têm complexidade O(n log n), mostram um desempenho muito melhor.
O Shell Sort também mostra um desempenho decente, mas ainda pior que os algoritmos O(n log n).
- ## **Vetor em ordem decrescente**:
O desempenho do Bubble Sort e do Insertion Sort piora consideravelmente devido à natureza inversa do vetor.
Algoritmos como Merge Sort, Quick Sort e Heap Sort mostram um desempenho mais estável em diferentes tipos de dados, mantendo uma complexidade O(n log n).
&nbsp;

### Em resumo, os resultados confirmam as expectativas em relação ao desempenho dos algoritmos de ordenação, com os algoritmos mais eficientes mostrando tempos menores, especialmente em conjuntos de dados maiores e aleatórios.
os resultados reforçam a importância de escolher algoritmos de ordenação adequados para o tipo de dado a ser ordenado e para a eficiência desejada. Algoritmos com complexidade assintótica mais baixa, como O(n log n), tendem a ser mais eficientes em grandes conjuntos de dados e em diferentes distribuições de dados, enquanto algoritmos com complexidade quadrática, como Bubble Sort e Insertion Sort, são mais adequados para conjuntos de dados pequenos ou parcialmente ordenados.