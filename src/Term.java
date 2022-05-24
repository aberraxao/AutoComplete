package src;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Depicts an Autocomplete Term: a string query and respective weight.
 * 
 * @author Diana Amaro
 * @author Diogo Ribeiro
 *
 */
public class Term implements Comparable<Term> {

	private String query;
	private long weight;

	/**
	 * Initializes a term with the given query string and weight.
	 * 
	 * @param query		Term's query
	 * @param weight	Term's weight
	 */
	public Term(String query, long weight)
	{
		if(query == null)
			throw new IllegalArgumentException("Query cannot be null");
		if(weight < 0)
			throw new IllegalArgumentException("Weight cannot be negative");

		this.query = query;
		this.weight = weight;
	}

	/**
	 * Compares the two terms in descending order by weight.
	 * 
	 * @return	Comparator by weight descending order
	 */
	public static Comparator<Term> byReverseWeightOrder()
	{
		return (thisTerm, thatTerm) -> Long.compare(thatTerm.weight, thisTerm.weight);
	}

	/**
	 * Compares the two terms in lexicographic order,
	 * but using only the first r characters of each query.
	 * 
	 * @param r number of characters to compare
	 * @return	Comparator by prefix order
	 */
	public static Comparator<Term> byPrefixOrder(int r)
	{
		if(r < 0)
			throw new IllegalArgumentException("r cannot be negative");

        return (thisTerm, thatTerm) ->
        {
        	//check if each query is longer than the specified prefix length (r) and trim it down
            String thisQuery = thisTerm.query.length() < r ? thisTerm.query : thisTerm.query.substring(0, r);
            String thatQuery = thatTerm.query.length() < r ? thatTerm.query : thatTerm.query.substring(0, r);
            
            return thisQuery.compareTo(thatQuery);
        };
	}
	
	/**
	 * Compares the two terms in lexicographic order by query.
	 * 
	 * @return	this Term to that Term comparison as a number: negative if less, zero if equal, positive if greater
	 */
	public int compareTo(Term that)
	{
		return this.query.compareTo(that.query);
	}

	/**
	 * Returns a string representation of this term in the following format:
	 * the weight, followed by a tab, followed by the query.
	 * 
	 * @return	Term formatted as a string
	 */
	public String toString()
	{
		return this.weight + "\t" + this.query;
	}

	/**
	 * unit testing (required)
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Test Constructor Exceptions (uncomment for testing)
		System.out.println("Constructor Exception - START");
//		Term eTerm1 = new Term(null, 15);
//		Term eTerm2 = new Term("Tokyo, City", -1);
		System.out.println("Constructor Exception - END");
		System.out.println();
	
		// Initialize several test Terms
		System.out.println("Initialize Terms - START");
		Term[] terms = new Term[4];
		terms[0] = new Term("Seoul, South Korea", 10349312);
		terms[1] = new Term("Buenos Aires, Argentina", 13076300);
		terms[2] = new Term("Mumbai, India", 12691836);
		terms[3] = new Term("Jakarta, Indonesia", 8540121);
		System.out.println("Initialize Terms - END");
		System.out.println();
		
		// Test toString
		System.out.println("toString - START");
		System.out.println("Term: "+ terms[0].toString());
		System.out.println("toString - END");
		System.out.println();
		
		// Test compareTo
		System.out.println("compareTo - START");
		System.out.println("compare " + terms[0].query + " to " + terms[1].query + " = " + terms[0].query.compareTo(terms[1].query));
		System.out.println("compare " + terms[0].query + " to " + terms[0].query + " = " + terms[0].query.compareTo(terms[0].query));
		System.out.println("compare " + terms[1].query + " to " + terms[0].query + " = " + terms[1].query.compareTo(terms[0].query));
		System.out.println("compareTo - END");
		System.out.println();
		
		// byPrefixOrder Tester
		System.out.println("byPrefixOrder - START");
		Arrays.sort(terms, byPrefixOrder(2));
		for(int i = 0; i < terms.length; i++)
		{
			System.out.println(terms[i].toString());
		}
		System.out.println("byPrefixOrder - END");
		
		System.out.println();
		
		// Test	byReverseWeightOrder
		System.out.println("byReverseWeightOrder - START");
		Arrays.sort(terms, byReverseWeightOrder());
		for(int i = 0; i < terms.length; i++)
		{
			System.out.println(terms[i].toString());
		}
		System.out.println("byReverseWeightOrder - END");
		System.out.println();
		
	}
}