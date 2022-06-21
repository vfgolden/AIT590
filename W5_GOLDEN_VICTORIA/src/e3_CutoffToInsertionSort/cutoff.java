package e3_CutoffToInsertionSort;

import e2_TracingQuicksort.TracingQuicksort;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StopwatchCPU;

import java.lang.Object;

/**
 * 
 * @author Victoria Golden
 * 
 *         Exercise 3: Cutoff to insertion sort (1 point)
 * 
 *         Implement the cutoff to insertion sort algorithm as described on page
 *         296.
 * 
 *         2.3.25 Cutoff to insertion sort. Implement quicksort with a cutoff to
 *         insertion sort for subarrays with less than M elements, and
 *         empirically determine the value of M for which quicksort runs fastest
 *         in your computing environment to sort random arrays of N doubles, for
 *         N = 103, 104, 105, and 106. Plot average running times for M from 0
 *         to 30 for each value of M. Note : You need to add a three-argument
 *         sort() method to Algorithm 2.2 for sorting subarrays such that the
 *         call Insertion.sort(a, lo, hi) sorts the subarray a[lo..hi].
 */

public class cutoff {

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
		int M = 7;
		if (hi <= lo + M) {
			Insertion.sort(a, lo, hi);
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
		assert isSorted(a, lo, hi);
		// print(a);
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

	public static void main(String[] args) {
		System.out.println("Cutoff to Insertion Sort By Victoria Golden");

		// Test 1
		StopwatchCPU stopTime = new StopwatchCPU();
		String[] name = { "V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N" };
		cutoff.sort(name);
		print(name);
		System.out.println(stopTime.elapsedTime());

		// Test 2
		stopTime = new StopwatchCPU();
		String[] array = { "V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O",
				"R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E",
				"N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A",
				"G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N" };
		cutoff.sort(array);
		print(array);
		System.out.println(stopTime.elapsedTime());

		// Test 2
		stopTime = new StopwatchCPU();
		String[] array2 = { "V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O",
				"R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E",
				"N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A",
				"G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "V", "I",
				"C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O",
				"L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O",
				"R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E",
				"N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "V", "I", "C", "T", "O", "R", "I",
				"A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I",
				"C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O",
				"L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O",
				"R", "I", "A", "G", "O", "L", "D", "E", "N", "V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D",
				"E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I",
				"A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I",
				"C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O",
				"L", "D", "E", "N", "V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T",
				"O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D",
				"E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I",
				"A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "V",
				"I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G",
				"O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T",
				"O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D",
				"E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "V", "I", "C", "T", "O", "R",
				"I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N",
				"I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G",
				"O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T",
				"O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L",
				"D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R",
				"I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N",
				"I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G",
				"O", "L", "D", "E", "N", "V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C",
				"T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L",
				"D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R",
				"I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N",
				"V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A",
				"G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C",
				"T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L",
				"D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "V", "I", "C", "T", "O",
				"R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E",
				"N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A",
				"G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C",
				"T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "V", "I", "C", "T", "O", "R", "I", "A", "G", "O",
				"L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O",
				"R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E",
				"N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A",
				"G", "O", "L", "D", "E", "N" };
		cutoff.sort(array2);
		print(array2);
		System.out.println(stopTime.elapsedTime());
	}

}
