package inclass_Activity1;

/**
 * 
 * @author Victoria Golden
 */
public class Activity_1 {

	/**
	 * Activity 1A: Method to print an array of integers
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
	 * Main Method with 3 tests for Activity 1B 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("In Class Activity 1 A & B by Victoria Golden");
		
		Integer[] arraytest1 = { 1, 4, 2, 5 };
		System.out.println("The integer array is:");
		String array1 = printArray(arraytest1);
		
		// test 1
		System.out.println("Test 1: Did array print correctly?");
		if (array1.equals("[1,4,2,5]")) {
			System.out.println("The array printed correctly");
		}else {
			System.out.println("The arrays do not equal.");
		}
		
		// test 2
		System.out.println("\nTest 2: Does array start and end with square brackets?");
		if (array1.startsWith("[")&&array1.endsWith("]")) {
			System.out.println("The array prints with square brackets on either end.");
		}else {
			System.out.println("The array did not print with brackets.");
		}
		
		//test 3
		System.out.println("\nTest 3: Does array have matching values?");
		array1 = array1.substring(1, array1.length()-1);
		String[] split = array1.split(",");
		for (int i = 0; i < arraytest1.length; i++) {
			if (split[i].equals(arraytest1[i].toString())) {
				System.out.println("Value " + i + " matches.");
			}else System.out.println(i + " does not match");
		}
	}
}
