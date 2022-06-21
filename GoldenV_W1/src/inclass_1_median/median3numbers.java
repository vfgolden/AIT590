package inclass_1_median;

/**
 * @author Victoria Golden
 * The purpose of this class is to find the median of 3 numbers
 */
public class median3numbers {

	/**
	 * @param num1, first number
	 * @param num2, second number
	 * @param num3, third number
	 * @return the median of the three numbers, type int
	 */
	public static int median(int num1, int num2, int num3) {
		// check for all instance of the 1st variable being less than the second
		if (num1 < num2) {
			if (num2 < num3) {
				return num2;
			} else if (num1 < num3) {
				return num3;
			} else {
				return num1;
			}
		} else {
			// check for instances of 1st variable being less than third
			if (num1 < num3) {
				return num1;
			} else if (num2 < num3) {
				return num3;
			}else {
				return num2;
			}
		}
	}

	/**
	 * Testing method for medium compute method
	 * @param title, string describing what is being tested
	 * @param num1, first number
	 * @param num2, second number
	 * @param num3, third number
	 */
	public static void median_test_method (String title, int num1, int num2, int num3) {
		System.out.print(title);
		System.out.print(num1);
		System.out.print(", ");
		System.out.print(num2);
		System.out.print(", ");
		System.out.print(num3);
		System.out.print("): ");
		System.out.println(median(num1,num2,num3));
	}
	
	/**
	 * main program
	 */
	public static void main(String[] args) {
		// print out title of program and author
		System.out.println("Median of 3 Numbers by Victoria Golden");
		
		//print out different test cases of median method
		median_test_method("The median of increasing values(",1,2,3);
		median_test_method("The median of decreasing values(",3,2,1);
		median_test_method("The median of random values(",12,8,17);
		median_test_method("The median of two like values(",9,9,6);
		median_test_method("The median of all like values(",7,7,7);
	}
}
