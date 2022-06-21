package e5_IgnoreSmallArrays;

/**
 * 
 * @author Victoria Golden
 *
 *         Exercise 5: Ignore small arrays (1 point)
 * 
 *         See Exercise 2.3.27.
 *         
 *         2.3.27 Ignore small subarrays. Run experiments
 *         to compare the following strategy for dealing with small subarrays
 *         with the approach described in Exercise 2.3.25: Simply ignore the
 *         small subarrays in quicksort, then run a single insertion sort after
 *         the quicksort completes. Note : You may be able to estimate the size
 *         of your computer’s cache memory with these experiments, as the
 *         performance of this method is likely to degrade when the array does
 *         not fit in the cache.
 */

public class IgnoreSmallArrays {

	// helper method
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w)>0;
	}
	
	// helper method
	@SuppressWarnings("rawtypes")
	private static void exch(Comparable[]a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	// copy element from source to destination
	private static Double[] copyArray(Double[] source) {
		Double[] destination = new Double[source.length];
		for (int i = 0; i< source.length; i++) {
			destination[i] = source [i];
		} return destination;
	}
	
	// sort array
	private static void sort (Comparable[] a, int cutoff) {
		sort(a, cutoff, a.length-1);
		insertionSort(a,0,a.length-1);
	}
	
	// sort from a[lo]]] to a[hi] using insertion sort
	@SuppressWarnings("rawtypes")
	private static void insertionSort(Comparable[]a, int lo, int hi) {
		for (int i=lo; i <=hi; i++) {
			for(int j= i; j>0 && less(a[j],a[j-1]); j--) {
				exch(a,j,j-1);
			}
		}
	}
	
	/**
	 * Method to partition; from the book pg. 291
	 * 
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static int partition(Comparable[] a, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
		int i = lo, j = hi + 1; // left and right scan indices
		Comparable v = a[lo]; // partitioning item

		while (true) { // Scan right, scan left, check for scan complete, and exchange.
			while (less(a[++i], v))
				if (i == hi)
					break;
			while (less(v, a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j); // Put v = a[j] into position
		return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
	}

	
	// quicksort
	private static void sort(Comparable[]a, int cutoff, int lo, int hi) {
		if (hi<=lo) {
			return;
		}
		int N = hi-lo +1;
		if (N <= cutoff) {
			return;
		}else {
			int j =partition(a,lo,hi);
			sort(a, cutoff, lo, j-1);
			sort(a, cutoff, j+1, hi);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Ignore Small Arrays By Victoria Golden");

		int size = 20;
		int maxVal = 50;
		
		// todo: figure out what the question is asking to then create the test cases
	}
}
