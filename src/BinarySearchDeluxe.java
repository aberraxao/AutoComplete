package src;

import java.util.Comparator;

/**
 * Static methods for binary searching for an instance of a key in a sorted array.
 * 
 * @author Diana Amaro
 * @author Diogo Ribeiro
 *
 */
public class BinarySearchDeluxe
{

	/**
	 * Returns the index of the first key in the sorted array a[]
	 * that is equal to the search key, or -1 if no such key.
	 * 
	 * @param <Key>			
	 * @param a				sorted array of Keys to be searched
	 * @param key			key to be searched for
	 * @param comparator	Comparator used to compare keys	
	 * @return	index of first key that matches search key. Or -1 if not found
	 */
	public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator)
	{
		return binarySearch(a, key, comparator, true);
	}

	/**
	 * Returns the index of the last key in the sorted array a[]
	 * that is equal to the search key, or -1 if no such key.
	 * 
	 * @param <Key>			
	 * @param a				sorted array of Keys to be searched
	 * @param key			key to be searched for
	 * @param comparator	Comparator used to compare keys	
	 * @return	index of last key that matches search key. Or -1 if not found
	 */
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator)
	{
		return binarySearch(a, key, comparator, false);
	}

	
	// binarySearch method to avoid code duplication
    private static <Key> int binarySearch(Key[] a, Key key, Comparator<Key> comparator, boolean isSearchingFirst)
    {
    	// arguments validation
    	if (a == null || key == null || comparator == null)
            throw new IllegalArgumentException("Arguments cannot be null");

    	if(a.length == 0)
    		return -1;
    	
        // binary search method
        int left = 0;
        int right = a.length - 1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            int compareResult = comparator.compare(key, a[mid]);

            // searchKey is greater than mid key
            if (compareResult > 0)
            	left = mid + 1;
            
            // searchKey is less than mid key
            else if (compareResult < 0)
            	right = mid - 1;

            // searchKey is equal to mid key
            // searching for first key in array
            else if (isSearchingFirst)
            {
            	// check if mid is the first pos of array. FirstIndex Found.
            	if ( mid == 0 )
            		return mid;
            	// check if value on a[mid-1] is less than searchKey. FirstIndex Found.
            	else if ( comparator.compare(key, a[mid - 1]) > 0 )
            		return mid;
            	// previous pos might be equal to searchKey. Check again.
            	else
            		right = mid - 1;
            }
            // searching for last key in array
            else
            {
            	// check if mid is the last pos of array. LastIndex Found.
            	if ( mid == a.length - 1 )
            		return mid;
            	// check if value on a[mid+1] is greater than searchKey. LastIndex Found.
            	else if ( comparator.compare(key, a[mid + 1]) < 0 )
            		return mid;
            	// next pos might be equal to searchKey. Check again.
            	else
            		left = mid + 1;
            }
        }
        // key not found
        return -1;
    }
	
	/**
	 * unit testing (required)
	 * 
	 */
	public static void main(String[] args)
	{
		// Initialize prefix
//		String prefix = "Seoul, South Korea";
		String prefix = "Jakarta, Indonesia";
//		String prefix = "Buenos Aires, Argentina";
//		String prefix = "Mumbai, India";
		
		String prefixNotFound = "Lisboa, Portugal";
		
		// Initialize sorted Terms[]
		System.out.println("Initialize Terms - START");
		Term[] terms = new Term[8];
		terms[0] = new Term("Buenos Aires, Argentina", 13076300);
		terms[1] = new Term("Buenos Aires, Argentina", 456789);
		terms[2] = new Term("Jakarta, Indonesia", 1234506);
		terms[3] = new Term("Jakarta, Indonesia", 7895465);
		terms[4] = new Term("Jakarta, Indonesia", 8540121);
		terms[5] = new Term("Mumbai, India", 12691836);
		terms[6] = new Term("Seoul, South Korea", 10349312);
		terms[7] = new Term("Seoul, South Korea", 12345);
		Term testTerm = new Term(prefix, 3);
		Term testTermNotFound = new Term(prefixNotFound, 3);
		System.out.println("Initialize Terms - END");
		System.out.println();
		
		// Test firstIndexOf
		System.out.println("firstIndexOf - START");
		int firstIndex = firstIndexOf(terms, testTerm, Term.byPrefixOrder(4));
        System.out.println("firstIndex: " + firstIndex);
        System.out.println("Term: " + terms[firstIndex].toString());
		System.out.println("firstIndexOf - END");
		System.out.println();

		// Test firstIndexOf - notFound
		System.out.println("firstIndexOf notFound - START");
		int firstIndexNotFound = firstIndexOf(terms, testTermNotFound, Term.byPrefixOrder(4));
        System.out.println("firstIndex: " + firstIndexNotFound);
		System.out.println("firstIndexOf notFound - END");
		System.out.println();
		
		
		// Test lastIndexOf
		System.out.println("lastIndexOf - START");
		int lastIndex = lastIndexOf(terms, testTerm, Term.byPrefixOrder(4));
        System.out.println("lastIndex: " + lastIndex);
        System.out.println("Term: " + terms[lastIndex].toString());
		System.out.println("lastIndexOf - END");
		System.out.println();
		
		// Test illegal arguments (uncomment for testing)
		System.out.println("illegalArguments - START");
//		int illegalArray = lastIndexOf(null, testTerm, Term.byPrefixOrder(4));
//		int illegalKey = lastIndexOf(terms, null, Term.byPrefixOrder(4));
//		int illegalComparator = lastIndexOf(terms, testTerm, null);
		System.out.println("illegalArguments - END");
		System.out.println();
		
	}

}