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
Search. Este algoritmo consiste na verificação dos valores
extremos de subarrays do array orginal 'a' que se tornam menores a cada
iteração do ciclo while. O critário
de paragem do Binary Search consiste em encontrar um valor 'mid' igual à key que
se procura.



Inicialmente o método faz uma verificação dos input
      // Valida os argumentos
      if (a == null || key == null || comparator == null)
         throw new IllegalArgumentException("Os argumentos não podem ser nulos");

      // O array a[] não possui elementos
      if (a.length == 0) return -1;

      // Aplica o método da Binary Search
      int left = 0;
      int right = a.length - 1;
      int match = -1;
      while (left <= right) {
         int mid = left + (right - left) / 2;
         int compareResult = comparator.compare(key, a[mid]);

         if (compareResult > 0) // A key procurada é superior à mid key
            left = mid + 1;
         else if (compareResult < 0) // A key procurada é inferior à mid key
            right = mid - 1;
         else { // A key procurada é igual à mid key
            match = mid;
            if (searchFirst) // Verifica se há uma key igual com índice menor
               right = mid - 1;
            else // Verifica se há uma key igual com índice maior
               left = mid + 1;
         }
      }

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

Autocomplete() : insertionsort e mergesort (algoritmo utilizado pelo Arrays.sort() para Objects - TimSort)

allMatches() : insertionsort e mergesort (algoritmo utilizado pelo Arrays.sort() para Objects - TimSort)

numberOfMatches() : 

/* *****************************************************************************
 *  Quantas comparações (no pior caso) cada uma das operações do
 *  Autocomplete faz, em função do número de itens n e do número de 
 *  matching terms m? Utilize a notação Big Theta para simplificar as
 *  suas respostas.
 *
 *  Recorde que com a notação Big Theta, deve descartar coeficientes
 *  e termos de ordem inferior, por exemplo, Theta(m^2 + m log n).
 **************************************************************************** */
TODO
Autocomplete():     Theta( n log n )

allMatches():       Theta( log n + m  )

numberOfMatches():  Theta(  log n  )



/* *****************************************************************************
 * Bugs / limitações conhecidas.
 **************************************************************************** */

Os testes unitários funcionam apenas com ficheiros que se encontrem no mesmo
formato que cities.txt e wiktionary.txt.


/* *****************************************************************************
 * Descreva qualquer ajuda (se houver) que tenha recebido.
 * Não inclua leituras, palestras, e preceitos, mas inclua qualquer ajuda de pessoas
 * (incluindo colegas do curso, amigos, monitores de laboratório, etc.)
 * Identificar os colegas de curso pelo nome.
 *
 * Incluir também quaisquer recursos (incluindo a web) que possa
 * ter sido utilizados na criação do seu desenho da solução.
 **************************************************************************** */
TODO Formatar
https://github.com/OxSon/AutoCompleteA03
https://github.com/danny666phantom/autoComplete
https://github.com/mpaquette18/AutoComplete

https://www.interviewkickstart.com/learn/time-complexities-of-all-sorting-algorithms
https://www.geeksforgeeks.org/timsort/
https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/
https://www.baeldung.com/arrays-sortobject-vs-sortint
https://www.baeldung.com/java-sorting

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
TODO melhorar
Achámos o tópico da pesquisa do Google muito interessante.