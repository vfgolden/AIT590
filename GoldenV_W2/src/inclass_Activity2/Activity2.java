package inclass_Activity2;

import java.util.Arrays;

public class Activity2 {

	/**
	 * Method to check if arrays are equal to each other
	 * @param array1
	 * @param array2
	 */
	public static void checkIfEqual(int[] array1, int[] array2) {
		if (Arrays.equals(array1, array2)) {
			System.out.print("Equal arrays:");
			System.out.print("[");
			for (int i = 0; i < array1.length; i++) {
				int value = array1[i];
				if (i != array1.length - 1) {
					System.out.print("");
					System.out.print(value);
					System.out.print(",");
				} else {
					System.out.print(value);
				}
			}
			System.out.print("],[");
			for (int i = 0; i < array2.length; i++) {
				int value = array2[i];
				if (i != array2.length - 1) {
					System.out.print("");
					System.out.print(value);
					System.out.print(",");
				} else {
					System.out.print(value);
				}
			}
			System.out.println("]");
		} else
			System.out.println("The arrays are not the same.\n");
	}

	/**
	 * Main method to test methods written
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("In Class Activity 2 A & B by Victoria Golden");
		
		// test two common value
		System.out.println("Test with two common elements result");
		int b1[] = { 9, 2, 6 };
		int b2[] = { 2, 1, 9 };
		checkIfEqual(b1, b2);

		// test all common values
		System.out.println("Test with all common elements but different order result");
		int c1[] = { 9, 6, 2 };
		int c2[] = { 2, 9, 6 };
		checkIfEqual(c1, c2);

		// boolean test if arrays are same
		System.out.println("Test with all common elements in same order result");
		int a1[] = { 2, 1, 3 };
		int a2[] = { 2, 1, 3 };
		checkIfEqual(a1, a2);
	}
}
