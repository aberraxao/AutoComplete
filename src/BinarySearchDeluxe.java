package src;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Métodos estáticos desenvolvidos para obter o índice da primeira ou da última
 * chave que iguala a key utilizando pesquisa binária.
 *
 * @author Diana Amaro
 * @author Diogo Ribeiro
 */
public class BinarySearchDeluxe {

   /**
    * Retorna o índice da primeira chave pertencente ao array ordenado a[] que
    * iguala a chave key. Caso não encontre a key retorna -1.
    *
    * @param a          array de pesquisa com chaves ordenadas
    * @param key        chave a igualar
    * @param comparator Comparator utilizado para comparar chaves
    * @return Índice da primeira chave igualada. Caso não encontre, retorna -1.
    */
   public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      return binarySearch(a, key, comparator, true);
   }

   /**
    * Retorna o índice da última chave pertencente ao array ordenado a[] que
    * iguala a chave key. Caso não encontre a key retorna -1.
    *
    * @param a          array de pesquisa com chaves ordenadas
    * @param key        chave a igualar
    * @param comparator Comparator utilizado para comparar chaves
    * @return Índice da última chave igualada. Caso não encontre, retorna -1.
    */
   public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      return binarySearch(a, key, comparator, false);
   }

   /**
    * Retorna o índice da primeira ou última chave pertencente ao array
    * ordenado a[] que iguala a chave key. Caso não encontre a key retorna -1.
    *
    * @param a           array de pesquisa com chaves ordenadas
    * @param key         chave a igualar
    * @param comparator  Comparator utilizado para comparar chaves
    * @param searchFirst Se true retorna a primeira chave, se false retorna a última
    * @return Índice da primeira ou última chave igualada. Caso não encontre, retorna -1.
    */
   private static <Key> int binarySearch(Key[] a, Key key, Comparator<Key> comparator, boolean searchFirst) {

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

      // Retorna a chave
      return match;
   }

   /**
    * Testes unitários
    *
    * @param args Nome do ficheiro de entrada
    */
   public static void main(String[] args) {
      StdOut.println("Inicia um conjunto de testes do módulo BinarySearchDeluxe...\n");

      Term[] testTerms = new Term[8];
      Term testTerm = new Term("Lisboa", 3);
      StdOut.println("INÍCIO: Testes das exceções de binarySearch");
      // As exceções de firstIndexOf e lastIndexOf são as mesmas, pois ambas
      // utilizam o mesmo método binarySearch
      try {
         binarySearch(null, testTerm, Term.byPrefixOrder(4), true);
      } catch (IllegalArgumentException e) {
         StdOut.println("Exceção do array");
      }
      try {
         binarySearch(testTerms, null, Term.byPrefixOrder(4), false);
      } catch (IllegalArgumentException e) {
         StdOut.println("Exceção da Key");
      }
      try {
         binarySearch(testTerms, testTerm, null, true);
      } catch (IllegalArgumentException e) {
         StdOut.println("Exceção com Comparator");
      }
      StdOut.println("FIM: Testes das exceções de binarySearch\n");

      // Lê os termos do ficheiro recebido em args[0] ou de "wiktionary.txt"
      String fileName;
      if (args.length == 0)
         fileName = "wiktionary.txt";
      else
         fileName = args[0];
      // Processa o ficheiro
      In in = new In(fileName);
      int n = in.readInt();
      Term[] terms = new Term[n];
      for (int i = 0; i < n; i++) {
         long weight = in.readLong();           // lê o próximo peso
         in.readChar();                         // lê a tab
         String query = in.readLine();          // lê a próxima consulta
         terms[i] = new Term(query, weight);    // contrói o termo
      }

      StdOut.println("INÍCIO: Testa índices não encontrados");
      Arrays.sort(terms, Term.byPrefixOrder(4));
      StdOut.printf("Primeiro índice de %s não encontrado: %d\n",
          testTerm.toString(),
          firstIndexOf(terms, testTerm, Term.byPrefixOrder(20)));
      StdOut.printf("Último índice de %s não encontrado: %d\n",
          testTerm.toString(),
          lastIndexOf(terms, testTerm, Term.byPrefixOrder(20)));
      StdOut.println("FIM: Testa índices não encontrados\n");

      StdOut.println("INÍCIO: Testa encontrar índices");
      testTerm = new Term("no", 1);
      Arrays.sort(terms, Term.byPrefixOrder(4));
      StdOut.printf("Primeiro índice de '%s' encontrado: %d\n",
          testTerm.toString(),
          firstIndexOf(terms, testTerm, Term.byPrefixOrder(2)));
      StdOut.printf("Último índice de '%s' encontrado: %d\n",
          testTerm.toString(),
          lastIndexOf(terms, testTerm, Term.byPrefixOrder(2)));
      StdOut.println("FIM: Testa encontrar índices\n");
   }
}