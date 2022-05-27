package src;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Implementa um tipo de dados que fornece a funcionalidade de preenchimento
 * automático para um determinado conjunto de strings e pesos.
 *
 * @author Diana Amaro
 * @author Diogo Ribeiro
 */
public class Autocomplete {
   private Term[] terms;

   /**
    * Inicializa a estrutura de dados a partir de um arrays de Termos
    *
    * @param terms array de Termos
    */
   public Autocomplete(Term[] terms) {
      // Valida os argumentos
      if (terms == null)
         throw new IllegalArgumentException("O vetor de termos não pode ser nulo");

      this.terms = terms;

      // Ordena o array lexicograficamente
      Arrays.sort(this.terms);
   }

   /**
    * Retorna por ordem decrescente de peso todos os termos que começam com um
    * determinado prefixo
    *
    * @param prefix prefixo dos termos
    * @return array de Termos ordenados por ordem decrescente de peso e que
    * começam com um determinado prefixo
    */
   public Term[] allMatches(String prefix) {
      // Valida os argumentos
      if (prefix == null) throw new IllegalArgumentException("O prefixo não pode ser nulo");

      Term[] matches;
      Term termToMatch = new Term(prefix, 0);

      // Obtém o primeiro índice
      int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, termToMatch, Term.byPrefixOrder(prefix.length()));
      // Se o primeiro índice for -1, então não foram encontrados resultados
      if (firstIndex == -1) {
         matches = new Term[1];
         matches[0] = new Term("Não foram encontrados resultados", 0);
         return matches;
      }

      // Obtém o último índice
      int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, termToMatch, Term.byPrefixOrder(prefix.length()));
      int nbMatches = lastIndex - firstIndex;

      // Preenche of vetor das igualdades com os termos encontrados
      matches = new Term[nbMatches];
      for (int i = 0; i < nbMatches; i++) {
         matches[i] = terms[firstIndex + i];
      }

      // Ordena o array por ordem descendente de peso
      Arrays.sort(matches, Term.byReverseWeightOrder());

      return matches;
   }

   /**
    * Retorna o número de termos que começam com o determinado prefixo
    *
    * @param prefix prefixo dos termos
    * @return número de termos que começam com o determinado prefixo
    */
   public int numberOfMatches(String prefix) {
      // Valida os argumentos
      if (prefix == null) throw new IllegalArgumentException("O prefixo não pode ser nulo");

      Term termToMatch = new Term(prefix, 0);

      int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, termToMatch, Term.byPrefixOrder(prefix.length()));
      int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, termToMatch, Term.byPrefixOrder(prefix.length()));

      return lastIndex - firstIndex + 1;
   }

   /**
    * Testes unitários
    *
    * @param args Nome do ficheiro de entrada
    */
   public static void main(String[] args) {
      StdOut.println("Inicia um conjunto de testes do módulo AutoComplete...\n");

      // Lê os termos do ficheiro recebido em args[0] ou de "cities.txt"
      String fileName;
      if (args.length == 0) fileName = "cities.txt";
      else fileName = args[0];
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

      StdOut.println("INÍCIO: Testes das exceções de AutoComplete");
      try {
         new Autocomplete(null);
      } catch (IllegalArgumentException e) {
         StdOut.println("Exceção de Autocomplete");
      }
      Autocomplete test = new Autocomplete(terms);
      try {
         test.allMatches(null);
      } catch (IllegalArgumentException e) {
         StdOut.println("Exceção de allMatches");
      }
      try {
         test.numberOfMatches(null);
      } catch (IllegalArgumentException e) {
         StdOut.println("Exceção de numberOfMatches");
      }
      StdOut.println("FIM: Testes das exceções de AutoComplete\n");

      StdOut.println("INÍCIO: Testa AutoComplete");
      StdOut.println("Imprime os primeiros 10 termos se existirem.");
      test = new Autocomplete(terms);
      for (int i = 0; i < terms.length && i < 10; i++)
         StdOut.printf("%s\n", test.terms[i].toString());
      StdOut.println("FIM: Testa AutoComplete\n");

      StdOut.println("INÍCIO: Testa allMatches");
      String prefix = "Lis";
      Term[] matches = test.allMatches(prefix);
      for (int i = 0; i < matches.length; i++)
         StdOut.printf("%s\n", matches[i].toString());
      StdOut.println("FIM: Testa allMatches\n");

      StdOut.println("INÍCIO: Testa numberOfMatches");
      int nrMatches = test.numberOfMatches(prefix);
      StdOut.printf("Número de termos que começam por '%s': %d\n", prefix, nrMatches);
      StdOut.println("FIM: Testa numberOfMatches\n");
   }
}