//* *****************************************************************************
 *  Nome: Diana Amaro
 *  No. de aluno: 103678
 *  Curso: LEI-PL
 *
 *  Outro(s) integrante(s):
 *  Nome:  Diogo Ribeiro
 *  No. de aluno: 103955
 *  Curso: LEI-PL
 *
 *  Horas para realizar o projeto (opcional):
 *
 **************************************************************************** */

Enunciado 2:  Autocomplete


/* *****************************************************************************
 *  Descreva como o seu método firstIndexOf() do BinarySearchDeluxe.java
 *  encontra o primeiro índice de uma chave que é igual à chave de pesquisa.
 **************************************************************************** */

O método recebe o array ordenado, a[], a chave de pesquisa, key, e o comparador,
comparator.
Após validar os argumentos, o método devolve -1 caso o array 'a' não contenha
elementos.
Em seguida procede com a aplicação de um algorimto que tem por base o Binary
Search. Este algoritmo consiste na verificação do valor que se encontra no meio
de cada subarray de 'a'. Como o array 'a' é ordenado, sabemos que se o elemento
do meio for maior que a 'key' que estamos à procura, então basta continuar a
pesquisa na metade esquerda do subarray até encontrar um valor mediano igual à
'key' ou não ser possível reduzir o tamanho do subarray.
No caso particular do algoritmo de firstIndexOf(), para além de encontrar a
'key' no array, temos que verificar se a posição da 'key' no array 'a' é a
primeira que contém o valor 'key'. Se ao varrermos os elementos à esquerda da
'key' até encontrarmos um valor menor ou chegarmos à posição 0 e houverem
outros valores iguais a 'key', o mais à esquerda deve ser considerado como o
primeiro índice com o valor 'key'.


/* *****************************************************************************
 *  Identificar qual algoritmo de ordenação (se houver) o seu programa utiliza no
 *  construtor do Autocomplete e nos métodos de instância. 
 *  Escolha uma das seguintes opções:
 *
 *    none, selection sort, insertion sort, mergesort, quicksort, heapsort
 *
 *  Se estiver a utilizar uma implementação optimizada, tal como Arrays.sort(),
 *  selecione o algoritmo que é utilizado internamente.
 **************************************************************************** */

Autocomplete() : insertion sort e merge sort (algoritmo utilizado pelo
                 Arrays.sort() para Objects - TimSort)

allMatches() : insertion sort e merge sort (algoritmo utilizado pelo Arrays.sort()
               para Objects - TimSort)

numberOfMatches() : binary search


/* *****************************************************************************
 *  Quantas comparações (no pior caso) cada uma das operações do
 *  Autocomplete faz, em função do número de itens n e do número de 
 *  matching terms m? Utilize a notação Big Theta para simplificar as
 *  suas respostas.
 *
 *  Recorde que com a notação Big Theta, deve descartar coeficientes
 *  e termos de ordem inferior, por exemplo, Theta(m^2 + m log n).
 **************************************************************************** */

Autocomplete():     Theta( n log n )

allMatches():       Theta( log n + m log m )

numberOfMatches():  Theta( log n )


/* *****************************************************************************
 * Bugs / limitações conhecidas.
 **************************************************************************** */

Os testes unitários funcionam apenas com ficheiros que se encontrem no mesmo
formato que 'cities.txt' e 'wiktionary.txt'. Caso o ficheiro não seja
especificado nos argumentos, um dos ficheiros de exemplo é utilizado.
No entanto, não é feita a verificação da existência destes ficheiros.


/* *****************************************************************************
 * Descreva qualquer ajuda (se houver) que tenha recebido.
 * Não inclua leituras, palestras, e preceitos, mas inclua qualquer ajuda de pessoas
 * (incluindo colegas do curso, amigos, monitores de laboratório, etc.)
 * Identificar os colegas de curso pelo nome.
 *
 * Incluir também quaisquer recursos (incluindo a web) que possa
 * ter sido utilizados na criação do seu desenho da solução.
 **************************************************************************** */

* What Is the Time Complexity of Arrays.sort() and Collections.sort() (2022).
Consultado em 27 maio 2022. Disponível em
https://www.gregorygaines.com/blog/what-is-the-time-complexity-arrays-and-collections-sort/
* Sorting in Java. (2022). Consultado em 23 maio 2022.
Disponível em https://www.baeldung.com/java-sorting
* Find first and last positions of an element in a sorted array. (2022).
Consultado em 26 maio 2022. Disponível em
https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array
* autoComplete. (2022). Consultado em 27 maio 2022.
Disponível em https://github.com/danny666phantom/autoComplete


/* *****************************************************************************
 * Descreva quaisquer problemas graves que tenha encontrado.                    
 **************************************************************************** */

Não houve problemas graves.


/* *****************************************************************************
 * Se trabalhou com um colega, afirme abaixo que seguiu
 * o protocolo, tal como descrito no enunciado. 
 * Incluir uma frase que explica como cada um de vós contribuiu para o projeto.
 **************************************************************************** */

O trabalho foi elaborado e revisto por ambas as partes conforme o protocolo.


/* *****************************************************************************
 * Listar aqui quaisquer outros comentários. Sinta-se à vontade para dar qualquer
 * feedback sobre o quanto aprendeu ao fazer o projeto, e se
 * gostou de o fazer.
 **************************************************************************** */

Achámos o tópico da pesquisa do Google muito interessante por diferir dos
exemplos apresentados nas aulas. Estes algoritmos foram revolucionários na época
em que foram implementados e atualmente continuam a ser bastante utilizados
desde a pesquisa de informação até à inteligência artificial.
