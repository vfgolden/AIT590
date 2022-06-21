package e2_ModifyBinarySearch;

import java.util.Arrays;

/**
 * 
 * @author Victoria Golden Exercise 1.4.10
 * 
 *         Assignment Instructions: Modify binary search so that it always
 *         returns the element with the smallest index that matches the search
 *         element (and still guarantees logarithmic running time).
 */

public class ModifyBinarySearch_1410 {

	/**
	 * Method to find the smallest index
	 * 
	 * @param array
	 * @param key
	 * @return index location
	 */
	public static int smallInd(int[] array, int key) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (key >= array[mid]) {
				if (key > array[mid])
					low = mid + 1;
				else {
					while (mid >= 0 && key == array[mid]) {
						mid--;
					}
					return ++mid;
				}
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * Method to generate random array
	 * 
	 * @param maxValue, max value of array
	 * @param size,     number of elements in array
	 * @return a random array of (size) values and maxValue
	 */
	public static int[] genRandomArray(int maxValue, int size) {
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * maxValue) + 1;
		}
		return array;
	}

	/**
	 * Testing Method for Main
	 * 
	 * @param title
	 * @param array
	 * @param key
	 */
	public static void testSmallestIndex(String title, int[] array, int key) {
		System.out.println(title);
		System.out.print("Smallest Index:");
		System.out.println(smallInd(array, key));
		System.out.println("Array tested: " + Arrays.toString(array));
	}

	/**
	 * Main Method for smallestIndex
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Smallest Index by Victoria Golden\n");

		int[] array1 = genRandomArray(26, 9);
		int[] array2 = genRandomArray(15, 30);
		int[] array3 = genRandomArray(19, 10);

		testSmallestIndex("Test 1", array1, 5);
		testSmallestIndex("Test 2", array2, 5);
		testSmallestIndex("Test 3", array3, 5);
		testSmallestIndex("Test 4", array2, 25);
		testSmallestIndex("Test 5", array3, 8);
	}

}
