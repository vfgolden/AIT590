package inclass_Activity3;

import java.util.Random;

/**
 * 
 * @author Victoria Golden ACTIVITY 3A: Count how many times a value appear in
 *         an array between two given indexes inclusive. ACTIVITY 3B: Test the
 *         count of how many times a value appear in an array between two given
 *         indexes inclusive.
 * 
 *         - identify 3 relevant tests (name of test, values)
 *
 */

public class Activity3 {

	/**
	 * Method to count the number of times a value appears in an array inclusive
	 * 
	 * @param start
	 * @param end
	 * @param array
	 * @param desiredValue
	 * @return
	 */
	public static Integer countArrayItems(Integer start, Integer end, Integer[] array, int desiredValue) {
		// initialize counter
		int counter = 0;

		for (int i = start; i <= end; i++) {
			if (array[i] == desiredValue) {
				counter++;
			}
		}

		return counter;
	}

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
	 * Main method to test the methods written
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("In Class Activity 3 A & B by Victoria Golden\n");

		// Test 1
		System.out.print("Test 1 Array:");
		int val = 5;
		int startIndex = 2;
		int endIndex = 8;
		int arraySize = startIndex + endIndex;
		Integer[] a = generateRandomArray(arraySize, 1, 5);
		printArray(a);
		System.out.println("The desired value is: " + val);
		System.out.println("The number of times the value is present in the array between start index " + startIndex
				+ " and end index " + endIndex + " equals " + countArrayItems(startIndex, endIndex, a, val));

		// Test 2
		System.out.print("\nTest 2 Array:");
		val = 3;
		startIndex = 1;
		endIndex = 3;
		arraySize = startIndex + endIndex;
		a = generateRandomArray(arraySize, 1, 5);
		printArray(a);
		System.out.println("The desired value is: " + val);
		System.out.println("The number of times the value is present in the array between start index " + startIndex
				+ " and end index " + endIndex + " equals " + countArrayItems(startIndex, endIndex, a, val));

		// Test 3
		System.out.print("\nTest 3 Array:");
		val = 20;
		startIndex = 2;
		endIndex = 5;
		arraySize = startIndex + endIndex;
		a = generateRandomArray(arraySize, 15, 20);
		printArray(a);
		System.out.println("The desired value is: " + val);
		System.out.print("The number of times the value is present in the array between start index " + startIndex
				+ " and end index " + endIndex + " equals " + countArrayItems(startIndex, endIndex, a, val));

	}

}
