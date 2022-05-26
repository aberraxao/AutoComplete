//* *****************************************************************************
 *  Nome: Diana Amaro
 *  No. de aluno: 
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

Autocomplete():     Theta( n log n )

allMatches():       Theta( log n + m  )

numberOfMatches():  Theta(  log n  )



/* *****************************************************************************
 * Bugs / limitações conhecidas.
 **************************************************************************** */


/* *****************************************************************************
 * Descreva qualquer ajuda (se houver) que tenha recebido.
 * Não inclua leituras, palestras, e preceitos, mas inclua qualquer ajuda de pessoas
 * (incluindo colegas do curso, amigos, monitores de laboratório, etc.)
 * Identificar os colegas de curso pelo nome.
 *
 * Incluir também quaisquer recursos (incluindo a web) que possa
 * ter sido utilizados na criação do seu desenho da solução.
 **************************************************************************** */

https://github.com/OxSon/AutoCompleteA03/blob/master/src/
https://github.com/danny666phantom/autoComplete/blob/master/
https://github.com/mpaquette18/AutoComplete/blob/master/src/
https://www.geeksforgeeks.org/
https://stackoverflow.com/

https://www.interviewkickstart.com/learn/time-complexities-of-all-sorting-algorithms
https://www.baeldung.com/arrays-sortobject-vs-sortint
https://www.geeksforgeeks.org/timsort/

https://www.baeldung.com/java-sorting#:~:text=As%20mentioned%20in%20the%20official,algorithm%20for%20Array%20of%20Objects.

* *****************************************************************************
 * Descreva quaisquer problemas graves que tenha encontrado.                    
 **************************************************************************** */




/* *****************************************************************************
 * Se trabalhou com um colega, afirme abaixo que seguiu
 * o protocolo, tal como descrito no enunciado. 
 * Incluir uma frase que explica como cada um de vós contribuiu para o projeto.
 **************************************************************************** */




/* *****************************************************************************
 * Listar aqui quaisquer outros comentários. Sinta-se à vontade para dar qualquer   
 * feedback sobre o quanto aprendeu ao fazer o projeto, e se    
 * gostou de o fazer.                                             
 **************************************************************************** */
