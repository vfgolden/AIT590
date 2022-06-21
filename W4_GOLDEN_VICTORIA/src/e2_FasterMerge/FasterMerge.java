package e2_FasterMerge;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Victoria Golden Exercise 2.2.10: Faster merge. Implement a version of
 *         merge() that copies the second half of a[] to aux[] in decreasing
 *         order and then does the merge back to a[]. This change allows you to
 *         remove the code to test that each of the halves has been exhausted
 *         from the inner loop. Note: The resulting sort is not stable (see page
 *         341).
 */

public class FasterMerge {

	public static class Merge {
		@SuppressWarnings("rawtypes")
		public static void sort(Comparable[] a) {
			Comparable[] aux = new Comparable[a.length]; // Allocate space just once.
			sort(a, aux, 0, a.length - 1);
		}

		@SuppressWarnings("rawtypes")
		private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
			// Sort a[lo..hi].
			if (hi <= lo)
				return;
			int mid = lo + (hi - lo) / 2;
			sort(a, aux, lo, mid); // Sort left half.
			sort(a, aux, mid + 1, hi); // Sort right half.
			merge(a, aux, lo, mid, hi); // Merge results (code on page 271).
		}

		@SuppressWarnings("rawtypes")
		public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
			// Merge a[lo..mid] with a[mid+1..hi].
			int i = lo, j = hi;
			// Copy a[mid+1] .. a[hi] to aux in decreasing order
			for (int k = lo; k <= mid; k++)
				aux[k] = a[k];
			for (int k = hi; k > mid; k--)
				aux[mid + 1 + hi - k] = a[k];
			// Merge from each end
			for (int k = lo; k <= hi; k++) {
				if (less(aux[i], aux[j]))
					a[k] = aux[i++];
				else
					a[k] = aux[j--];
			}
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		private static boolean less(Comparable v, Comparable w) {
			return v.compareTo(w) < 0;
		}
	}

	public static void main(String[] args) {
		System.out.println("Faster Merge by Victoria Golden");
		int n = 25;

		// Test 1
		Integer[] a = new Integer[n];
		Random r1 = new Random();
		for (int i = 0; i < n; i++) {
			a[i] = r1.nextInt(n);
		}
		Merge.sort(a);
		System.out.println("Test 1 Array: " + Arrays.toString(a));

		// Test 2
		Random r2 = new Random();
		for (int i = 0; i < n; i++) {
			a[i] = r2.nextInt(n);
		}
		Merge.sort(a);
		System.out.println("Test 2 Array: " + Arrays.toString(a));

		// Test 1
		Random r3 = new Random();
		for (int i = 0; i < n; i++) {
			a[i] = r3.nextInt(n);
		}
		Merge.sort(a);
		System.out.println("Test 3 Array: " + Arrays.toString(a));
	}
}
