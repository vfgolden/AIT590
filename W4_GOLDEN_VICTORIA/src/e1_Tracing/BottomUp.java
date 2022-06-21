package e1_Tracing;

/**
 * @author Victoria Golden
 *	Exercise 1: Bottom Up Merge Sort
 *
 */

import java.util.Arrays;

public class BottomUp {

	@SuppressWarnings("rawtypes")
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

		// copy to aux[]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
			// System.out.println("Copying Values: "+ Arrays.toString(aux));
		}

		// merge back to a[]
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			// System.out.println("Merging indexes: " + k + " & "+ i);
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

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		int count = 0;
		int n = a.length;
		Comparable[] aux = new Comparable[n];
		for (int len = 1; len < n; len *= 2) {
			for (int lo = 0; lo < n - len; lo += len + len) {
				count++;
				int mid = lo + len - 1;
				int hi = Math.min(lo + len + len - 1, n - 1);
				System.out.println("\nMerge " + count + ": " + Arrays.toString(a));
				merge(a, aux, lo, mid, hi);
				System.out.printf("Merge(a, %2d, %2d, %2d) ", lo, lo + len - 1, Math.min(lo + len + len - 1, n - 1));
				System.out.println();
				System.out.print("Values: [ ");
				for (int i = lo; i <= Math.min(lo + len + len - 1, n - 1); i++) {
					System.out.print(a[i] + " ");
				}
				System.out.println("]");
			}
		}
	}

	// check to see if variable 1 is less than variable 2
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static boolean less(Comparable var1, Comparable var2) {
		return var1.compareTo(var2) < 0;
	}

	@SuppressWarnings("rawtypes")
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

	public static void main(String[] args) {
		System.out.println("Merge Bottom Up by Victoria Golden\n");

		String[] array = { "V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N" };
		System.out.print("Unformatted Input Array:" + Arrays.toString(array));
		BottomUp.sort(array);

		System.out.print("\nSorted array after last merge: ");
		show(array);
	}

}
