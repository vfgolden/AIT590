package e1_Tracing;

/**
 * 
 * @author Victoria Golden Exercise 1 Tracing (1 point):
 * 
 *         Merge sorted arrays (0.3 points): Based on the above guided
 *         activities, perform the following traces and submit your answer. For
 *         Activity 1: Merge sorted arrays order the letters in your first name,
 *         order the letters in your last name and then show the trace for
 *         merging them as described in Activity 1. For the next two parts:
 *         Write the letters in your name as a sequence without spaces (first
 *         name, middle name, last name). In my case the sequence is: M I H A I
 *         B O I C U. Following the model in the guided modules 2 and 3, submit
 *         a trace of how the 2 merge sorts algorithms will sort the letter in
 *         alphabetic order. In my example the sort result will be: A B C H I I
 *         I M O U . Be sure, that each step of the algorithm is clearly
 *         presented in the result table. Top Down Merge Sort Grading: 0.3
 *         points Bottom Up Merge Sort, Grading: 0.4 points
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Random;

public class Merge {

	// merge two arrays using an auxillary array
	private static void merge(Comparable[] array, Comparable[] auxArray, int lo, int mid, int hi) {

		// copy to auxArray[]
		for (int k = lo; k <= hi; k++) {
			auxArray[k] = array[k];
		}

		// merge back to array[]
		int i = lo, j = mid + 1; // start the pointers at the left side
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				array[k] = auxArray[j++];
				// System.out.print(array[k]+",");
			} else if (j > hi) {
				array[k] = auxArray[i++];
				// System.out.print(array[k]+",");
			} else if (less(auxArray[j], auxArray[i])) {
				array[k] = auxArray[j++];
				// System.out.print(array[k]+",");
			} else {
				array[k] = auxArray[i++];
				// System.out.print(array[k]+",");
			}
		}
	}

	private static void sort(Comparable[] array, Comparable[] auxArray, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(array, auxArray, lo, mid); // sort the left half
		sort(array, auxArray, mid + 1, hi); // sort the right half.
		merge(array, auxArray, lo, mid, hi); // merge the two sorted halves
	}

	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length]; // Allocate space just once.
		sort(a, aux, 0, a.length - 1);
	}

	// check to see if variable 1 is less than variable 2
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static boolean less(Comparable var1, Comparable var2) {
		return var1.compareTo(var2) < 0;
	}

	public static void main(String[] args) {
		System.out.println("Merge by Victoria Golden");
		
		Integer[] b = { 12, 1, 0, 4, 2, 8, 1, 3, 6, 5, 2, 9, 0, 1 };
		System.out.print("Initial Array: ");
		System.out.println(Arrays.toString(b));
		Merge.sort(b);
		System.out.print("Sorted Array: ");
		System.out.println(Arrays.toString(b));
	}

}