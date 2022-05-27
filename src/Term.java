package src;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Implementa a classe Term com a query (consulta) e o respetivo weight (peso).
 *
 * @author Diana Amaro
 * @author Diogo Ribeiro
 */
public class Term implements Comparable<Term> {

   private final String query;
   private final long weight;

   /**
    * Inicializa o Term com a respetiva query e weight.
    *
    * @param query  consulta do termo
    * @param weight peso do termo
    */
   public Term(String query, long weight) {
      // Valida os argumentos
      if (query == null)
         throw new IllegalArgumentException("A consulta não pode ser nula");
      if (weight < 0)
         throw new IllegalArgumentException("O peso não pode ser negativo");

      this.query = query;
      this.weight = weight;
   }

   /**
    * Compara dois termos por ordem descendente de peso
    *
    * @return Comparator ordenado por ordem de peso descendente
    */
   public static Comparator<Term> byReverseWeightOrder() {
      return (thisTerm, thatTerm) ->
          Long.compare(thatTerm.weight, thisTerm.weight);
   }

   /**
    * Compara dois termos por ordem lexicográfica por string de consulta
    * (ordem natural), comparando apenas os seus primeiros 'r' caracteres.
    *
    * @param r número de caracteres a comparar
    * @return Comparator ordenado por ordem lexicográfica
    */
   public static Comparator<Term> byPrefixOrder(int r) {
      // Valida os argumentos
      if (r < 0)
         throw new IllegalArgumentException("O número de caracteres não pode ser negativo");

      return (thisTerm, thatTerm) -> {

         // Se o comprimento da consulta for superior ao número de caracteres,
         // considera apenas os primeiros r
         String thisQuery = thisTerm.query.length() < r
             ? thisTerm.query : thisTerm.query.substring(0, r);
         String thatQuery = thatTerm.query.length() < r
             ? thatTerm.query : thatTerm.query.substring(0, r);

         return thisQuery.compareTo(thatQuery);
      };
   }

   /**
    * Compara dois termos por ordem lexicográfica por string de consulta
    * (ordem natural)
    *
    * @return Valor do termo this em comparação com o termo that:
    * negativo se this menor, zero se iguais, positivo se this maior
    */
   public int compareTo(Term that) {
      return this.query.compareTo(that.query);
   }

   /**
    * Devolve uma respresentação do termo no formato:
    * peso, seguido da tabulação, seguido da consulta
    *
    * @return Term com formato string
    */
   public String toString() {
      return String.format("%d\t%s", this.weight, this.query);
   }

   /**
    * Testes unitários
    *
    * @param args Nome do ficheiro de entrada
    */
   public static void main(String[] args) {
      StdOut.println("Inicia um conjunto de testes do módulo Term...\n");

      StdOut.println("INÍCIO: Testes das exceções do construtor");
      try {
         new Term(null, 15);
      } catch (IllegalArgumentException e) {
         StdOut.println("Exceção da consulta testada");
      }
      try {
         new Term("Tokyo, City", -1);
      } catch (IllegalArgumentException e) {
         StdOut.println("Exceção do peso testada");
      }
      StdOut.println("FIM: Testes das exceções do construtor\n");

      // Lê os termos do ficheiro recebido em args[0] ou de "cities.txt"
      String fileName;
      if (args.length == 0)
         fileName = "cities.txt";
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

      StdOut.println("INÍCIO: Testa toString");
      StdOut.printf("Term: %s\n", terms[0].toString());
      StdOut.println("FIM: Testa toString\n");

      StdOut.println("INÍCIO: Testa compareTo");
      StdOut.printf("Comparação '%s' vs '%s' = %d\n",
          terms[0].query,
          terms[1].query,
          terms[0].query.compareTo(terms[1].query));
      StdOut.printf("Comparação '%s' vs '%s' = %d\n",
          terms[0].query,
          terms[0].query,
          terms[0].query.compareTo(terms[0].query));
      StdOut.printf("Comparação '%s' vs '%s' = %d\n",
          terms[1].query,
          terms[0].query,
          terms[1].query.compareTo(terms[0].query));
      StdOut.println("FIM: Testa compareTo\n");

      StdOut.println("INÍCIO: Testa byPrefixOrder");
      try {
         Arrays.sort(terms, byPrefixOrder(-5));
      } catch (IllegalArgumentException e) {
         StdOut.println("Exceção do comprimento testada");
      }
      Arrays.sort(terms, byPrefixOrder(20));
      StdOut.println("Se existirem, imprime os primeiros 10 termos ordenados.");
      for (int i = 0; (i < terms.length && i < 10); i++)
         StdOut.println(terms[i].toString());
      StdOut.println("FIM: Testa byPrefixOrder\n");

      StdOut.println("INÍCIO: Testa byReverseWeightOrder");
      Arrays.sort(terms, byReverseWeightOrder());
      StdOut.println("Se existirem, imprime os primeiros 10 termos ordenados.");
      for (int i = 0; (i < terms.length && i < 10); i++)
         StdOut.println(terms[i].toString());
      StdOut.println("FIM: Testa byReverseWeightOrder\n");

      StdOut.println("Termina o conjunto de testes do módulo Term");
   }
}