package src;

import java.util.Arrays;

/**
 * Implements data type with autocomplete functionality for a given set of strings and weights. 
 * 
 * @author Diana Amaro
 * @author Diogo Ribeiro
 */
public class Autocomplete
{
    private Term[] terms;
	
	/**
	 * Initializes the data structure from the given array of terms.
	 * 
	 * @param terms	array of terms to use
	 */
	public Autocomplete(Term[] terms)
	{
		// arguments validation
        if (terms == null)
            throw new NullPointerException("Argument cannot be null");

        this.terms = terms;

		// order lexicographically
        Arrays.sort(this.terms);
	}


	/**
	 * Returns all terms that start with the given prefix, in descending order of weight .
	 * 
	 * @param prefix	prefix to be searched
	 * @return	array of terms that start with the given prefix, in descending order of weight
	 */
	public Term[] allMatches(String prefix)
	{
		// arguments validation
		if(prefix == null)
			throw new IllegalArgumentException("Argument cannot be null");
		
		Term[] matches;
		Term termToMatch = new Term(prefix, 0);
		
		// gets first and last index
		int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, termToMatch, Term.byPrefixOrder(prefix.length()));
		int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, termToMatch, Term.byPrefixOrder(prefix.length()));
		int length = lastIndex - firstIndex + 1;
		
		// checks if no results were found and returns a single "No results found" term
		if( firstIndex == -1 || lastIndex == -1 )
		{
			matches = new Term[1];
			matches[0] = new Term("No results found", 0);
			return matches;
		}
		
		// check if first index is equal or bigger than last index
		if( firstIndex <= lastIndex )
			matches = new Term[length];
		else
			matches = new Term[0];

		// get all terms between first and last index
		if(matches.length != 0)
		{
			for(int i = 0; i < length; i++)
			{
				matches[i] = terms[firstIndex + i];
			}
		}

		// sorts matches by reverse weight order
		Arrays.sort(matches, Term.byReverseWeightOrder());
		
		return matches;
	}

	/**
	 * Returns the number of terms that start with the given prefix.
	 * 
	 * @param prefix	prefix to be searched
	 * @return	number of terms that start with the given prefix
	 */
	public int numberOfMatches(String prefix)
	{
        Term termToMatch = new Term(prefix, 0);
        
        int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, termToMatch, Term.byPrefixOrder(prefix.length()));
		int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, termToMatch, Term.byPrefixOrder(prefix.length()));
		
        return lastIndex - firstIndex + 1;
	}

	/**
	 * unit testing (required)
	 * 
	 */
	public static void main(String[] args)
	{
		// Initialize several test Terms
		System.out.println("Initialize Terms - START");
		Term[] terms = new Term[8];
		terms[0] = new Term("Seoul, South Korea", 12345);
		terms[1] = new Term("Buenos Aires, Argentina", 13076300);
		terms[2] = new Term("Buenos Aires, Argentina", 456789);
		terms[3] = new Term("Mumbai, India", 12691836);
		terms[4] = new Term("Jakarta, Indonesia", 8540121);
		terms[5] = new Term("Jakarta, Indonesia", 7895465);
		terms[6] = new Term("Jakarta, Indonesia", 1234506);
		terms[7] = new Term("Seoul, South Korea", 10349312);
		System.out.println("Initialize Terms - END");
		System.out.println();
		
		// Initialize prefix
//		String prefix = "Seoul, South Korea";
		String prefix = "Jakarta, Indonesia";
//		String prefix = "Buenos Aires, Argentina";
//		String prefix = "Mumbai, India";
//		String prefix = "Lisboa, Portugal";
		
		// Test Constructor
		System.out.println("Test Constructor - START");
		Autocomplete test = new Autocomplete(terms);
        for (int i = 0; i < test.terms.length; i++)
        	System.out.println(test.terms[i]);
		System.out.println("Test Constructor - END");
		System.out.println();
		
		// Test allMatches
		System.out.println("Test allMatches - START");
		Term[] matches = test.allMatches(prefix);
		for (int i = 0; i < matches.length; i++)
			System.out.println(matches[i]);
		System.out.println("Test allMatches - END");
		System.out.println();
		
		// Test numberOfMatches
		System.out.println("Test numberOfMatches - START");
		int nrMatches = test.numberOfMatches(prefix);
		System.out.println("numberOfMatches: " + nrMatches);
		System.out.println("Test numberOfMatches - END");
		System.out.println();

	}
}