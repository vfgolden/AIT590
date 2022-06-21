package e2_InsertionSort;

public class InsertionSort_RtoL {

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static boolean more(Comparable v, Comparable w) {
		return v.compareTo(w) > 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) { // Print the array, on a single line.
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static boolean isSorted(Comparable[] a) { // Test whether the array entries are in order.
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static void sort(Comparable[] a) {
		// Sort a[] into increasing order.
		int N = a.length;
		for (int i = N - 1; i > 0; i--) {
			for (int j = i; j < N; j++) {
				if (less(a[j - 1], a[j])) {
					exch(a, j, j - 1);
					show(a);
				}
			}
		}
	}

	public static void main(String[] args) { // Read strings from standard input, sort them, and print.
		String[] a = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		sort(a);
		System.out.println("\n");

		assert isSorted(a);
		show(a);
	}

}
