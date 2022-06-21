package e1_RandomArray;

import java.util.Arrays;

/**
 * 
 * @author Victoria Golden Exercise 1.4.8
 * 
 *         Assignment Instructions: Write a program to determine the number
 *         pairs of values in an input file that are equal. If your first try is
 *         quadratic, think again and use Arrays.sort() to develop a
 *         linearithmic solution.
 */

public class RandomArray_148 {
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
	 * Method to count the number of pairs that are equal in value
	 * 
	 * @param array
	 * @return count so numbered pairs
	 */
	public static int countNumPairs(int[] array) {
		// sort the array first
		Arrays.sort(array);

		// initialize the counter
		int count = 0;
		// initialize a counter to keep track of values that are in a series
		int sameVal = 1;

		for (int i = 1; i < array.length; i++) {
			if (array[i] == array[i - 1]) {
				sameVal++;
			} else {
				if (sameVal > 1) {
					count += (sameVal - 1) * sameVal / 2;
					sameVal++;
				}
			}
		}

		if (sameVal > 1) {
			count += (sameVal - 1) * sameVal / 2;
		}
		return count;
	}

	/**
	 * Testing method for main
	 * 
	 * @param title
	 * @param array
	 */
	public static void randomArraytest(String title, int[] array) {
		System.out.println(title);
		System.out.println(countNumPairs(array));
	}

	public static void main(String[] args) {
		System.out.println("Test Random Array by Victoria Golden\n");

		int[] array1 = genRandomArray(26, 9);
		int[] array2 = genRandomArray(15, 30);
		int[] array3 = genRandomArray(19, 10);

		randomArraytest("Test 1: ", array1);
		System.out.println("Array generated: " + Arrays.toString(array1)+"\n");
		randomArraytest("Test 2: ", array1);
		System.out.println("Array generated: " + Arrays.toString(array1)+"\n");
		randomArraytest("Test 3: ", array2);
		System.out.println("Array generated: " + Arrays.toString(array2)+"\n");
		randomArraytest("Test 4: ", array3);
		System.out.println("Array generated: " + Arrays.toString(array3)+"\n");
		randomArraytest("Test 5: ", array3);
		System.out.println("Array generated: " + Arrays.toString(array3)+"\n");
	}

}
