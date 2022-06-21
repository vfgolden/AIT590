package e3_NaturalMergeSort;

import edu.princeton.cs.algs4.Stopwatch;

import java.util.Random;

/**
 * @author Victoria Golden
 * 
 *         Exercise 2.2.16: Natural mergesort. Write a version of bottom-up
 *         mergesort that takes advantage of order in the array by proceeding as
 *         follows each time it needs to ﬁnd two arrays to merge: find a sorted
 *         subarray (by incrementing a pointer until finding an entry that is
 *         smaller than its predecessor in the array), then ﬁnd the next, then
 *         merge them. Analyze the running time of this algorithm in terms of
 *         the array size and the number of maximal increasing sequences in the
 *         array.
 */

public class NaturalMergeSort {

	public static class BottomUpNaturalMerge {
		@SuppressWarnings("rawtypes")
		public static void sort(Comparable[] a) {
			int N = a.length;
			Comparable[] aux = new Comparable[N];
			while (true) {
				for (int lo = 0; lo < N - 2; lo++) {
					int mid = lo;
					while (mid < N - 2 && !less(a[mid + 1], a[mid]))
						mid++;
					int hi = mid + 1;
					while (hi < N - 1 && !less(a[hi + 1], a[hi]))
						hi++;
					merge(a, aux, lo, mid, hi);
					if (hi - lo == N - 1)
						return;
					lo = hi;
				}
			}
		}

		@SuppressWarnings("rawtypes")
		public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
			// Merge a[lo..mid] with a[mid+1..hi].
			int i = lo, j = mid + 1;
			for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
				aux[k] = a[k];
			for (int k = lo; k <= hi; k++) { // Merge back to a[lo..hi].
				if (i > mid) {
					a[k] = aux[j++];
				} else if (j > hi) {
					a[k] = aux[i++];
				} else if (less(aux[j], aux[i])) {
					a[k] = aux[j++];
				} else {
					a[k] = aux[i++];
				}
			}
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		private static boolean less(Comparable v, Comparable w) {
			return v.compareTo(w) < 0;
		}

		@SuppressWarnings("rawtypes")
		public static boolean isSorted(Comparable[] a) {
			for (int i = 1; i < a.length; i++)
				if (less(a[i], a[i - 1]))
					return false;
			return true;
		}
	}

	public static void randomTest(int range, int size) {
		Random r = new Random();
		Stopwatch s;
		double time = 0;

		// Random arrays
		for (int t = 0; t < range; t++) {
			Integer[] a = new Integer[size];
			Integer[] b = new Integer[size];
			for (int i = 0; i < size; i++) {
				a[i] = r.nextInt();
				b[i] = a[i];
			}
			// Bottom up natural
			s = new Stopwatch();
			BottomUpNaturalMerge.sort(b);
			time += s.elapsedTime();
		}
		System.out.printf("%10s %8.4f\n", "Sorting random array with " + size + " items. Execution time: ", time);
	}

	public static void increasingTest(int range, int size) {
		Random r = new Random();
		Stopwatch s;
		double time = 0;

		// increasing arrays
		for (int t = 0; t < range; t++) {
			Integer[] a = new Integer[size];
			Integer[] b = new Integer[size];
			for (int i = 0; i < size; i++) {
				if (i > 0 && r.nextDouble() > 0.2)
					a[i] = a[i - 1] + 1;
				else
					a[i] = r.nextInt(size);
				b[i] = a[i];
			}

			// Bottom up natural
			s = new Stopwatch();
			BottomUpNaturalMerge.sort(b);
			time += s.elapsedTime();
		}
		System.out.printf("%10s %8.4f\n", "Sorting increasing array with " + size + " items. Execution time: ", time);
	}

	public static void main(String[] args) {
		System.out.println("Natural Merge Sort by Victoria Golden\n");

		randomTest(200, 500);
		randomTest(100, 100);
		randomTest(1000,2000);
		increasingTest(200,500);
		increasingTest(100,100);
		increasingTest(1000,2000);

	}

}
