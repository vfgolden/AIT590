package inclass_Activity4;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Arrays;

public class Activity4 {

	/**
	 * Method to count the number of triples that sum to 0 in an array
	 * @param arr
	 * @return
	 */
	public static int threeSum(int[] arr) {
		// First sort the array.
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			// initialize left and right
			int l = i + 1;
			int r = arr.length - 1;
			int x = arr[i];
			while (l < r) {
				if (x + arr[l] + arr[r] == 0) {
					System.out.print("Set of elements equal to 0: ");
					// print elements if it's sum is zero
					System.out.print(x + " ");
					System.out.print(arr[l] + " ");
					System.out.println(arr[r] + " ");

					l++;
					r--;
					count++;
				}

				// If sum of three elements is less
				// than zero then increment in left
				else if (x + arr[l] + arr[r] < 0)
					l++;

				// if sum is greater than zero than
				// decrement in right side
				else
					r--;
			}
		}
		return count;
	}

	/**
	 * Method to print an array of Integers
	 * @param array
	 * @return
	 */
	public static String printArray(int[] array) {
		StringBuilder printedArray = new StringBuilder("[");

		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				printedArray.append(array[i]).append(",");
			} else {
				printedArray.append(array[i]).append("]");
			}
		}
		return printedArray.toString();
	}

	/**
	 * main method to perform three tests of written methods
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("In Class Activity 4 A, B, & C by Victoria Golden");
		ZonedDateTime startTime = ZonedDateTime.now();
		System.out.println("Execution occurred at: " + startTime + "\n");

		int[] arr1 = { -100, -50, 1, 66, 33, 50, 0, 34 };
		int[] arr2 = { 0, -1, 2, -3, 1 };
		int[] arr3 = { 2, -1, -1, -3, 99 };

		// test 1
		System.out.println("Test 1 array: " + printArray(arr1));
		System.out.println("Test 1 triples equaling 0 count: " + threeSum(arr1) + "\n");
		
		// test 2
		System.out.println("Test 2 array: " + printArray(arr2));
		System.out.println("Test 2 triples equaling 0 count: " + threeSum(arr2)+ "\n");
		
		// test 3
		System.out.println("Test 1 array: " + printArray(arr3));
		System.out.println("Test 3 triples equaling 0 count: " + threeSum(arr3) + "\n");

		ZonedDateTime endTime = ZonedDateTime.now();
		System.out.println("Execution occurred at: " + endTime);
		System.out.println("Total execution duration: " + Duration.between(startTime, endTime).toString());
	}
}
