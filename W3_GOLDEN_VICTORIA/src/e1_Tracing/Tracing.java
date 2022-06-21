package e1_Tracing;

/**
 * @author Victoria Golden 
 * 
 * Exercise 1 - Tracing
 * 
 *         Assignment Instructions: Write the letters in your name as a sequence
 *         without spaces (first name, middle name, last name). In my case the
 *         sequence is: M I H A I B O I C U. Following the model in the guided
 *         module, submit a trace of how the 3 elementary sorts algorithms will
 *         sort the letter in alphabetic order. In my example the sort result
 *         will be: A B C H I I I M O U . Be sure, that each step of the
 *         algorithm is clearly presented in the result table. Grading: 0.3
 *         points selection sort, 0.3 points insertion sort and 0.4 points shell
 *         sort. Each tracing mistake will take out .05 points from your result.
 */

public class Tracing {
	/**
	 * Method for insertion sort, sorts right to left
	 * 
	 * @param name
	 * @param n
	 */
	@SuppressWarnings("rawtypes")
	private static void insertionSort(Comparable[] name, int n) {
		int count = 0;
		for (int i = n - 1; i > 0; i--) {
			for (int j = i; j < n && !less(name[j - 1], name[j]); j++)
				exch(name, j, j - 1);
			count++;
			System.out.print("Exchange " + count + " Result: ");
			print(name);
		}
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
	 * Method to selection sort
	 * 
	 * @param name
	 * @param n
	 */
	@SuppressWarnings("rawtypes")
	public static void selectionSort(Comparable[] name, int n) {
		int min;
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			min = i;
			for (int j = i + 1; j < n; j++)
				if (less(name[j], name[min]))
					min = j;
			if (min != i) {
				Comparable aux = name[i];
				name[i] = name[min];
				name[min] = aux;
			}
			count++;
			System.out.print("Exchange " + count + " Result: ");
			print(name);
		}
	}

	/**
	 * Method to Shellsort
	 * 
	 * @param name
	 * @param n
	 */
	@SuppressWarnings("rawtypes")
	public static void shellsort(Comparable[] name, int n) {
		int count = 0;
		int h = 1;
		while (h < n / 3) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			for (int i = h; i < n; i++) {
				for (int j = i; j >= h && less(name[j], name[j - h]); j -= h) {
					count++;
					System.out.print("Exchange " + count + " Result: ");
					exch(name, j, j - h);
					print(name);
				}
			}
			h /= 3;
		}
	}

	/**
	 * Method to print array in specific format
	 * 
	 * @param a
	 */
	@SuppressWarnings("rawtypes")
	private static void print(Comparable[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++)
			if (i != a.length - 1) {
				System.out.print(a[i] + ", ");
			} else {
				System.out.print(a[i]);
			}
		System.out.println("]");
	}

	/**
	 * Main method with primary arguments
	 * 
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String args[]) {
		System.out.println("Tracing by Victoria Golden\n");

		Comparable[] name0 = { "V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N" };
		Comparable[] name1 = { "V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N" };
		Comparable[] name2 = { "V", "I", "C", "T", "O", "R", "I", "A", "G", "O", "L", "D", "E", "N" };

		System.out.println("Insertion Sort Trace: ");
		insertionSort(name0, name0.length);
		System.out.println("\nSelection Sort Trace: ");
		selectionSort(name1, name1.length);
		System.out.println("\nShell Sort Trace: ");
		shellsort(name2, name2.length);
	}
}
