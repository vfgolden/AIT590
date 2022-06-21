package bonus_CompareSearching;

import java.util.Arrays;

import edu.princeton.cs.algs4.Stopwatch;

public class CompareSearching {

	/**
	 * Method #1
	 * @param array
	 * @param key
	 * @return
	 */
	public static boolean searchUnsortedArray(int[] array, int key) {
		for (int i=0; i< array.length;i++) {
			if (key == array[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method #2
	 * @param array
	 * @param key
	 * @return
	 */
	public static int searchSortedArray(int[] array, int key) {
		Stopwatch time = new Stopwatch();
		Arrays.sort(array);
		int a = indexOf(array,key);
		System.out.println(time.elapsedTime());
		return a;
	}


	/**
	 * Method #3A
	 * 
	 * @param maxValue, max value of array
	 * @param size,     number of elements in array
	 * @return a random array of (size) values and maxValue
	 */
	public static int[] genRandomArray_3A(int maxValue, int size) {
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * maxValue) + 1;
		}
		return array;
	}


	/**
	 * Method #3B
	 * @param array
	 * @return
	 */
	public static int[] copyArray_3B(int[] array) {
		int[] copy = new int[array.length];

		// Copy elements of array[] to copy[]
		for (int i = 0; i < array.length; i++)
			copy[i] = array[i];

		return copy;
	}
	
	/**
	 * Method #3C
	 * @param maxValue
	 * @param size
	 * @return
	 */
	public static int[] genRandomArray_3C(int maxValue, int size) {
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			if (i % 2 == 0) {
				array[i] = (int) (Math.random() * array.length) + 1;
			} else
				array[i] = (int) (Math.random() * maxValue) + 1;

		}
		return array;
	}

	/**
	 * Binary Search code from book
	 * 
	 * Returns the index of the specified key in the specified array.
	 *
	 * @param a   the array of integers, must be sorted in ascending order
	 * @param key the search key
	 * @return index of key in array {@code a} if present; {@code -1} otherwise
	 */
	public static int indexOf(int[] a, int key) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			// Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	
	public static void test(int[] array, int key) {
		Stopwatch time = new Stopwatch();
		int[] copy1 = copyArray_3B(array);
		searchUnsortedArray(copy1,key);
		System.out.println(time.elapsedTime());
	}

	public static void main(String[] args) {
		System.out.println("Bonus Exercise: Compare Searching by Victoria Golden\n");

		// Method #3A: Generate 10 random arrays
		int[] one = genRandomArray_3A(1000000, 100000);
		int[] two = genRandomArray_3A(1000000, 100000);
		int[] three = genRandomArray_3A(1000000, 100000);
		int[] four = genRandomArray_3A(1000000, 100000);
		int[] five = genRandomArray_3A(1000000, 100000);
		int[] six = genRandomArray_3A(1000000, 100000);
		int[] seven = genRandomArray_3A(1000000, 100000);
		int[] eight = genRandomArray_3A(1000000, 100000);
		int[] nine = genRandomArray_3A(1000000, 100000);
		int[] ten = genRandomArray_3A(1000000, 100000);
		
		
		System.out.print("Testing Search in Unsorted Array. Time Elapsed: ");
		test(one,100000);
		
		System.out.print("Testing Search in Sorted Array. Time Elapsed: ");
		searchSortedArray(one,100000);
	}

}
