package e4_MedianOfThree;

import e2_TracingQuicksort.TracingQuicksort;
import e3_CutoffToInsertionSort.cutoff;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StopwatchCPU;

/**
 * 
 * @author Victoria Golden
 *
 *         Exercise 4: Median of three partitioning (1 point)
 * 
 *         Implement the median of three algorithm as described on page 296.
 */

public class MedianOfThreePartitioning {

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
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
		assert isSorted(a, lo, hi);
		// print(a);
	}

	
	@SuppressWarnings("unchecked")
	public static Comparable MedianThree(Comparable a, Comparable b, Comparable c) {
		if ((a.compareTo(b)) != (a.compareTo(c))) {
			return a;
		} else if (b.compareTo(a) != b.compareTo(c)) {
			return b;
		} else return c;
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
		int mid = (a.length/2) -1;
		Comparable v = MedianThree(a[lo], a[hi], a[mid]); // partitioning item

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
		System.out.println("Median of Three Partitioning By Victoria Golden");

		// Test 1
				StopwatchCPU stopTime = new StopwatchCPU();
				String[] name = { "V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N" };
				MedianOfThreePartitioning.sort(name);
				print(name);
				System.out.println(stopTime.elapsedTime());

				// Test 2
				stopTime = new StopwatchCPU();
				String[] array = { "V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O",
						"R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E",
						"N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A",
						"G", "O", "L", "D", "E", "N", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N" };
				MedianOfThreePartitioning.sort(array);
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
						"G", "O", "L", "D", "E", "N" ,"V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O",
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
						"G", "O", "L", "D", "E", "N" ,"V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O",
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
						"G", "O", "L", "D", "E", "N" ,"V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N", "I", "C", "T", "O",
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
				MedianOfThreePartitioning.sort(array2);
				print(array2);
				System.out.println(stopTime.elapsedTime());
	}
}
