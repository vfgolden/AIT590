package e4_GraphDataType_GuidedAssignment;

import e1_413.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TestGraph {

	/**
	 * Unit tests the {@code Graph} data type.
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
		In in = new In("https://algs4.cs.princeton.edu/41graph/tinyG.txt");
		Graph G = new Graph(in);
		StdOut.println(G);
	}
}
