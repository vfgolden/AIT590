package e3_InBothArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Victoria Golden
 *
 *         Class that returns the common values between two arrays 
 *         
 *         Exercise 1.4.12: Write a program that, given two sorted arrays of N int
 *         values, prints all elements that appear in both arrays, in sorted
 *         order. The running time of your program should be proportional to N
 *         in the worst case.
 *         
 *         Limitation: captures common values between two arrays for 1st array only
 */

public class InBothArrays_1412 {

	/**
	 * Method to generate a random array
	 * 
	 * @param numElem
	 * @param min
	 * @param max
	 * @return
	 */

	public static Integer[] generateRandomArray(int numElem, int min, int max) {
		if (min >= max) {
			System.out.println("Min is >= to Max. Returning empty array with 0 elements.");
			Integer[] array = new Integer[0];
			return array;
		}

		if (numElem <= 0) {
			System.out.println(
					"Specified element number of " + numElem + " isn't valid. Returning empty array with 0 elements.");
			Integer[] array = new Integer[0];
			return array;
		}

		Integer[] array = new Integer[numElem];

		for (int i = 0; i < array.length; i++) {
			Random random = new Random();
			array[i] = random.nextInt((max - min) + 1) + min;
		}
		return array;
	}

	/**
	 * Method to print an array of integers
	 * 
	 * @param array
	 */
	public static String printArray(Integer[] array) {
		StringBuilder printedArray = new StringBuilder("[");

		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				printedArray.append(array[i]).append(",");
			} else {
				printedArray.append(array[i]).append("]");
			}
		}
		System.out.println(printedArray.toString());
		return printedArray.toString();
	}

	/**
	 * Helper method for printing array
	 */
	public void addMember(Integer x) {
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(x);
	}

	/**
	 * Method to check if array elements are equal to each other
	 * 
	 * @param array1
	 * @param array2
	 */
	public static void checkIfEqual(Integer[] array1, Integer[] array2) {
		Arrays.sort(array1);
		Arrays.sort(array2);

		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (array1[i] == array2[j]) {
					System.out.print(" " + array1[i]);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Exercise 1.4.12 by Victoria Golden\n");

		// Test 1
		System.out.println("Test 1");
		Integer[] testArray1 = generateRandomArray(10, 1, 100);
		printArray(testArray1);
		Integer[] testArray2 = generateRandomArray(5, 1, 100);
		printArray(testArray2);
		System.out.print("Common Values: ");
		checkIfEqual(testArray1, testArray2);
		System.out.println("\n");

		// Test 2
		System.out.println("Test 2");
		testArray1 = generateRandomArray(7, 42, 86);
		printArray(testArray1);
		testArray2 = generateRandomArray(7, 42, 86);
		printArray(testArray2);
		System.out.print("Common Values: ");
		checkIfEqual(testArray1, testArray2);
		System.out.println("\n");

		// Test 3
		System.out.println("Test 3");
		testArray1 = generateRandomArray(5, 1, 5);
		printArray(testArray1);
		testArray2 = generateRandomArray(5, 1, 5);
		printArray(testArray2);
		System.out.print("Common Values: ");
		checkIfEqual(testArray1, testArray2);
		System.out.println("\n");
	}
}
