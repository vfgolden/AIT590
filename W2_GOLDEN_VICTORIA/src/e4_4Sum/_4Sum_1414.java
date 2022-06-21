package e4_4Sum;

/**
 * Exercise 1.4.14 4-sum
 * 
 * Assignment Instructions: 4-sum. Develop an algorithm for the 4-sum problem.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4Sum_1414 {

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
			array[i] = (int) (Math.random() * maxValue) +- 1;
		}
		return array;
	}

	/**
	 * Method to check if a set of 4 items in an array equal to key
	 *
	 * @param array
	 * @param key
	 * @return count
	 */

	public static List<List<Integer>> fourSum(int[] array, int key) {
		List<List<Integer>> count = new ArrayList<List<Integer>>();

		if (array == null || array.length < 4)
			return count;

		Arrays.sort(array);

		for (int i = 0; i < array.length - 3; i++) {
			if (i != 0 && array[i] == array[i - 1])
				continue;
			for (int j = i + 1; j < array.length - 2; j++) {
				if (j != i + 1 && array[j] == array[j - 1])
					continue;
				int k = j + 1;
				int l = array.length - 1;
				while (k < l) {
					if (array[i] + array[j] + array[k] + array[l] < key) {
						k++;
					} else if (array[i] + array[j] + array[k] + array[l] > key) {
						l--;
					} else {
						List<Integer> value = new ArrayList<>();
						value.add(array[i]);
						value.add(array[j]);
						value.add(array[k]);
						value.add(array[l]);
						count.add(value);
						k++;
						l--;
						while (k < l && array[l] == array[l + 1]) {
							l--;
						}
						while (k < l && array[k] == array[k - 1]) {
							k++;
						}
					}
				}
			}
		}
		return count;
	}

	public static void testFourSum(String title, int[] array, int key) {
		System.out.println(title);
		System.out.print("Passing tested values (overflow considered): ");
		System.out.println(fourSum(array, key));
	}

	public static void main(String[] args) {
		System.out.println("Four Sum by Victoria Golden\n");

		int[] array1 = { -2147483647 - 8, 10, 2147483647 + 8, -10, 0, 1, -1 };
		testFourSum("Testing case 1", array1, 1);
		int[] array2 = { -2147483647, 2147483647, 5, 0, -5, 2, -2 };
		testFourSum("Testing case 2", array2, 5);
		int[] array3 = genRandomArray(100,100);
		testFourSum("Testing case 3", array3, 1);
		int[] array4 = genRandomArray(100,200);
		testFourSum("Testing case 4", array4, 1);
		int[] array5 = genRandomArray(10,100);
		testFourSum("Testing case 5", array5, 1);
	}
}
