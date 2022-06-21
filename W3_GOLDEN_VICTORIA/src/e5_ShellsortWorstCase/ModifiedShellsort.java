package e5_ShellsortWorstCase;

/**
 * 
 * @author Victoria Golden
 *
 *         Exercise 5: based on 2.1.19 Shellsort worst case - page 265 (1 point,
 *         1 bonus point): Perform the following steps (modified book question
 *         for 111 elements):
 * 
 *         Create a method to randomly generate an array of 111 elements with
 *         the numbers from 1 to 111 Modify shell sort to compute and return the
 *         number of compares between the array elements it executes Create an
 *         experiment to determine the answer and print the best array(s) found,
 *         with the elements separated by space. The student(s) that will
 *         generated the most compares will get a bonus point (but need to be a
 *         correct result) Include in the answer the list of elements separated
 *         by space. If tied in the number of compares the more arrays you
 *         submit with that number of compares you win. In case of another tie,
 *         the bonus point is divided to the number of students with both ties.
 */

public class ModifiedShellsort {

	/**
	 * Rearranges the array in ascending order, using the natural order.
	 *
	 * @param a the array to be sorted
	 */
	@SuppressWarnings("rawtypes")
	public static int shell_sort(Comparable[] array) {

		int n = array.length;
		int count = 0;

		int h = 1;
		while (h < n / 3)
			h = 3 * h + 1;

		while (h >= 1) {
			for (int i = h; i < n; i++) {
				for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) {
					exch(array, j, j - h);

					count++;
				}
			}
			h /= 3;
		}
		// System.out.println("Shell Sort exchange count: " + count);
		return count;
	}

	/**
	 * Swaps two integers in an array in textbook
	 *
	 * @param a array
	 * @param i first integer
	 * @param j second integer
	 */
	@SuppressWarnings("rawtypes")
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	/**
	 * Method to compare two variables and return which is less
	 *
	 * @param v first comparable
	 * @param w second comparable
	 * @return lesser object
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * print array to standard output
	 *
	 * @param a array to print
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	private static void print(Comparable[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	/**
	 * Create random array
	 *
	 * @param max  value in array
	 * @param min  value in array
	 * @param size total capacity of array
	 * @return random array
	 */
	@SuppressWarnings("rawtypes")
	public static Comparable[] genRandomArray(int max, int min, int size) {
		Comparable[] array = new Comparable[size];
		for (int i = 0; i < array.length; i++)
			array[i] = (int) (Math.random() * ((max - min) + 1)) + min;
		return array;
	}

	/**
	 * Main method
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Shellsort worst case by Victoria Golden");

		int min = 1;
		int max = 111;
		int size = 111;

		System.out.println("Test Shellsort Worst Case 1");
		System.out.println("Array dimensions: min value = " + min + " max value = " + max + " & array size = " + size);
		System.out.println("Shell Sort exchange count: " + shell_sort(genRandomArray(max, min, size)));
		System.out.println("");

		System.out.println("Test Shellsort Worst Case 2");
		System.out.println("Array dimensions: min value = " + min + " max value = " + max + " & array size = " + size);
		System.out.println("Shell Sort exchange count: " + shell_sort(genRandomArray(max, min, size)));
		System.out.println("");

		System.out.println("Test Shellsort Worst Case 3");
		System.out.println("Array dimensions: min value = " + min + " max value = " + max + " & array size = " + size);
		System.out.println("Shell Sort exchange count: " + shell_sort(genRandomArray(max, min, size)));
		System.out.println("");

		System.out.println("Test Shellsort Worst Case 4");
		System.out.println("Array dimensions: min value = " + min + " max value = " + max + " & array size = " + size);
		System.out.println("Shell Sort exchange count: " + shell_sort(genRandomArray(max, min, size)));
		System.out.println("");

		System.out.println("Test Shellsort Worst Case 5");
		System.out.println("Array dimensions: min value = " + min + " max value = " + max + " & array size = " + size);
		int counted = 0;
		while (counted < 715) {
			counted = shell_sort(genRandomArray(max, min, size));
		}
		System.out.println("Shell Sort exchange attempted max count: " + counted);
	}
}
