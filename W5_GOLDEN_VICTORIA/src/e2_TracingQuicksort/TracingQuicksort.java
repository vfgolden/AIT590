package e2_TracingQuicksort;

import e1_TracingPartition.TracingPartition;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 * @author Victoria Golden
 * 
 *         Exercise 2: Tracing quicksort (1 point)
 * 
 *         For each recursive call specify the depth of the call (start with 1
 *         for top level call and at each recursive call go one level deeper):
 * 
 *         Level 1: sort (0, 9) Level 2: partition (0, 9) = 1 Level 2: sort(0,0)
 *         Level 2: sort(2, 9)
 */

public class TracingQuicksort {

	// initialize count of partition for recursive function
	private static int partitionLevel = 1;
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
		System.out.println("Level " + partitionLevel + " partition(" + lo + "," +hi + ")");
		int j = partition(a, lo, hi);
		partitionLevel++;
		System.out.println("Level " + partitionLevel + " sort(" + lo + "," +hi + ")");
		sort(a, lo, j - 1);
		partitionLevel--;
		partitionLevel++;
		System.out.println("Level " + partitionLevel + " sort(" + lo + "," +hi + ")");
		sort(a, j + 1, hi);
		partitionLevel--;
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
		System.out.println("Trace Quicksort By Victoria Golden");

		String[] name = { "V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N" };
		TracingQuicksort.sort(name);
		//print(name);
	}
	
}
