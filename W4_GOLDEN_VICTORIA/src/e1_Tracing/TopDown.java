package e1_Tracing;

import java.util.Arrays;

/**
 * @author Victoria Golden
 * 
 * Exercise 1: Top Down Merge Sort
 */

public class TopDown {

	private static int count = 0;

	// This class should not be instantiated.
	private TopDown() {
	}

	// stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

		// copy to aux[]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		// merge back to a[]
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

	// mergesort a[lo..hi] using auxiliary array aux[lo..hi]
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		System.out.print("\nMerge " + count + ": " + Arrays.toString(a));
		merge(a, aux, lo, mid, hi);
		count++;
		System.out.printf("\nMerge(a, %2d, %2d, %2d) ", lo, mid, hi);
		System.out.println();
		System.out.print("Values: [ ");
		for (int i = lo; i <= hi; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("]");
	}

	/**
	 * Rearranges the array in ascending order, using the natural order.
	 * 
	 * @param a the array to be sorted
	 */
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}

	/***************************************************************************
	 * Helper sorting function.
	 ***************************************************************************/

	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	// mergesort a[lo..hi] using auxiliary array aux[lo..hi]
	private static void sort(Comparable[] a, int[] index, int[] aux, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, index, aux, lo, mid);
		sort(a, index, aux, mid + 1, hi);
	}

	// print array to standard output
	private static void show(Comparable[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			if (i != a.length - 1) {
				System.out.print(a[i] + " ");
			} else
				System.out.print(a[i]);
		}
		System.out.println("]");
	}

	/**
	 * Reads in a sequence of strings from standard input; mergesorts them; and
	 * prints them to standard output in ascending order.
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
		System.out.println("Merge Top Down by Victoria Golden\n");

		String[] array = { "V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N" };
		System.out.print("Unformatted Input Array:" + Arrays.toString(array));
		System.out.println();
		TopDown.sort(array);

		System.out.print("\nSorted array after last merge: ");
		show(array);
	}
}
