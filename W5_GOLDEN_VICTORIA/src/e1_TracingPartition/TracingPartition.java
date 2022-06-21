package e1_TracingPartition;

/**
 * 
 * @author Victoria Golden
 *
 *         Exercise 1: Tracing partition (1 point)
 * 
 *         Trance the execution of the Partition method for your name in
 *         capitals (first name followed by last name with no space)
 * 
 *         For each iteration in the outer while loop specify the values for
 *         elements in the array, i and j.
 *
 */

import edu.princeton.cs.algs4.StdRandom;

public class TracingPartition {
	/**
	 * Rearranges the array in ascending order, using the natural order.
	 * 
	 * @param a the array to be sorted
	 */
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
		assert isSorted(a);
	}

	// quicksort the subarray from a[lo] to a[hi]
	@SuppressWarnings("rawtypes")
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		//print(a);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
		assert isSorted(a, lo, hi);
	//	print(a);
	}

	/**
	 * Method to compare if one variable is less than another variable
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	/**
	 * Method to exchange array item positions
	 * 
	 * @param array
	 * @param a
	 * @param b
	 */
	@SuppressWarnings("rawtypes")
	private static void exch(Comparable[] array, int a, int b) {
		Comparable t = array[a];
		array[a] = array[b];
		array[b] = t;
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
		System.out.print("before");
		print(a);

		while (true) { // Scan right, scan left, check for scan complete, and exchange.
			while (less(a[++i], v))
				if (i == hi)
					break;
			while (less(v, a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			System.out.println("exchanging i: " + a[i] + " with j: " + a[j]);
			exch(a, i, j);
		}
		System.out.print("after");
		print(a);

		System.out.println("exchanging lo: " + a[lo] + " with j: " + a[j]);
		exch(a, lo, j); // Put v = a[j] into position
		print(a);
		return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
	}

	/**
	 * helper methods to check if array is sorted
	 * 
	 * @param a
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	@SuppressWarnings("rawtypes")
	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	/**
	 * Method to print array in specific format
	 * 
	 * @param a
	 */
	@SuppressWarnings({ "rawtypes" })
	private static void print(Comparable[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++)
			if (i != a.length - 1) {
				System.out.print(a[i] + " ");
			} else {
				System.out.print(a[i]);
			}
		System.out.println("]");
	}

	/**
	 * Main testing method
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		System.out.println("Trace Partition By Victoria Golden");

		String[] name = { "V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N" };
		TracingPartition.sort(name);
		//print(name);
	}

}
