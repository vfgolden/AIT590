package e2_415;

import e1_413.Graph;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author Victoria Golden
 *
 *         Exercise 4.1.5 Modify Graph to disallow parallel edges and
 *         self-loops. (try to define one that contains each of them and see
 *         that error is shown)
 * 
 */

public class ModifyGraph {
	public class Modified extends Graph {

		public Modified(int vertices) {
			super(vertices);
		}

		@Override
		public void addEdge(int vertex1, int vertex2) {
			// Self-loops and parallel edges not allowed
			if (vertex1 == vertex2 || hasEdge(vertex1, vertex2)) {
				return;
			}

			super.addEdge(vertex1, vertex2);
		}

		private boolean hasEdge(int vertex1, int vertex2) {
			for (int neighbor : adjacent(vertex1)) {
				if (neighbor == vertex2) {
					return true;
				}
			}

			return false;
		}

	}

	/**
	 * Unit tests for no parallel edges
	 * @param args
	 */
	public static void main(String[] args) {
		StdOut.println("Exercise 4.1.5 by Victoria Golden\n");

		ModifyGraph G = new ModifyGraph();
		Modified noEdgenoParallel = G.new Modified(5);

		// add edges
		noEdgenoParallel.addEdge(0, 1);
		noEdgenoParallel.addEdge(1, 4);
		noEdgenoParallel.addEdge(2, 3);
		StdOut.println("Number of edges = " + noEdgenoParallel.E() + " vs expected of 3");
		noEdgenoParallel.addEdge(1, 0);
		StdOut.println("Number of edges = " + noEdgenoParallel.E() + " vs expected of 3");
		noEdgenoParallel.addEdge(2, 4);
		StdOut.println("Number of edges = " + noEdgenoParallel.E() + " vs expected of 4");
		noEdgenoParallel.addEdge(4, 4);
		StdOut.println("Number of edges = " + noEdgenoParallel.E() + " vs expected of 4");
		noEdgenoParallel.addEdge(3, 4);
		StdOut.println("Number of edges = " + noEdgenoParallel.E() + " vs expected of 5");
	}

}
