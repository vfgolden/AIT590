package inclass_2_commonelements;

/**
 * Count the number of common elements between two arrays
 * with distinct integer values
 * @author Victoria Golden
 *
 */
public class CountofCommonElements {
	/**
	 * Use boolean to return either true for if a value is in a given array
	 * otherwise false if value is not found
	 * @param arr, array of values being checked
	 * @param check, value being checked for
	 * @return True for found value, otherwise false
	 */
	public static boolean checkIfContains(int[] arr, int check) {
		// check through all values in the array
		for (int i=0; i<arr.length; i++) {
			int value = arr[i];
			//check if value in array is equal to @param check
			if (value==check) {
				// return true for match
				return true;
			}
		}
		// return false for no match in array
		return false;
	}
	
	/**
	 * Count the number of common values between two arrays of integers.
	 * @param arr1 The first array of integers
	 * @param arr2 The second array of integers
	 * @return count of common elements
	 */
	public static int countCommonElements(int arr1[], int arr2[]) {
		// initialize counter
		int counter = 0;
		// loop through arr1 to check for common element
		for (int i = 0; i < arr1.length; i++) {
			// set value1 as element placeholder for checkIfContains
			int value1 = arr1[i];
			// check if value1 from arr1 is in arr2
			if (checkIfContains(arr2,value1)) {
				// increase count of counter
				counter ++;
			}
		}
		// return counter which represents the number of common elements
		return counter;
	}

	
	/**
	 * Test count the number of common values between two arrays of integers.
	 * Show the result as: 
	 * countCommonValues([1,2,3], [2,3,4]) = 2
	 * @param title string passed in from main test method
	 * @param arr1 array of integers
	 * @param arr2 second array of integers
	 */
	public static void testCountCommonElements(String title, int arr1[], int arr2[]) {
		System.out.println(title);	
		System.out.print("Arrays:");
		System.out.print("[");
		for (int i = 0; i < arr1.length; i++) {
			int value = arr1[i];
			if(i!=arr1.length-1) {
				System.out.print("");
				System.out.print(value);
				System.out.print(",");
			} else {
				System.out.print(value);
			}
		}
		System.out.print("],[");
		for (int i = 0; i < arr2.length; i++) {
			int value = arr2[i];
			if(i!=arr2.length-1) {
			System.out.print("");
			System.out.print(value);
			System.out.print(",");
			} else {
				System.out.print(value);
			}
		}
		System.out.println("]");
		System.out.print("Count of common elements:");
		System.out.println(countCommonElements(arr1, arr2));
		System.out.println();
	}
	
	/**
	 * Main method with test cases
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println("Count of Common Elements by Victoria Golden");
		System.out.println();		
		// test no common values
		int a1[] = {9,2,6};
		int a2[] = {3,1,5};
		testCountCommonElements("Test with no common elements", a1, a2);
		// test two common value
		int b1[] = {9,2,6};
		int b2[] = {2,1,9};
		testCountCommonElements("Test with two common elements", b1, b2);
		// test all common values
		int c1[] = {9,6,2};
		int c2[] = {2,9,6};
		testCountCommonElements("Test with all common elements", c1, c2);	
		// test first array is empty 
		int d1[] = {};
		int d2[] = {2,1,3};
		testCountCommonElements("Test with first array is empty", d1, d2);
		// test second array is empty 
		testCountCommonElements("Test with second array is empty", d2, d1);	
		// test both empty arrays
		testCountCommonElements("Test with both empty arrays", d1, d1);	
	}
}
