package e1_SelectionSort;

public class SelectionSort_RtoL {

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static boolean more(Comparable v, Comparable w) {
		return v.compareTo(w) >= 0;
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

	public static void sort(Comparable[] a) { // Sort a[] into increasing order.
		int N = a.length; // array length
		for (int i = N - 1; i >= 0; i--) {
			int max = i;
			for (int j = i - 1; j >= 0; j--)
				if (more(a[j], a[max]))
					max = j;
			exch(a, i, max);
		}
	}
	

	public static void main(String[] args) { // Read strings from standard input, sort them, and print.
		String[] a = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
