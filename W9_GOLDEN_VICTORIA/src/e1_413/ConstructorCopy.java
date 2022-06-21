package e1_413;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author Victoria Golden
 * 
 *         Exercise 4.1.3 Create a copy constructor for Graph that takes as
 *         input a graph G and creates and initializes a new copy of the graph.
 *         Any changes a client makes to G should not affect the newly created
 *         graph.
 *         
 */

public class ConstructorCopy {

	public class CopyGraph {
		private final int vertices;
		private int edges;
		private Bag<Integer>[] adjacent;

		@SuppressWarnings("unchecked")
		public CopyGraph(int vertices) {
			this.vertices = vertices;
			this.edges = 0;
			adjacent = (Bag<Integer>[]) new Bag[vertices];

			for (int i = 0; i < vertices; i++) {
				adjacent[i] = new Bag<>();
			}
		}

		public int vertices() {
			return vertices;
		}

		public int edges() {
			return edges;
		}
		
		public CopyGraph(In in) {
			this(in.readInt());
			int edges = in.readInt();

			for (int i = 0; i < edges; i++) {
				int vertex1 = in.readInt();
				int vertex2 = in.readInt();
				addEdge(vertex1, vertex2);
			}
		}

		@SuppressWarnings("unchecked")
		public CopyGraph(Graph graph) {
			if (graph == null) {
				vertices = 0;
			} else {
				this.vertices = graph.V();
				this.edges = graph.E();
				adjacent = (Bag<Integer>[]) new Bag[vertices];

				for (int i = 0; i < vertices; i++) {
					adjacent[i] = new Bag<>();
				}

				for (int vertex = 0; vertex < graph.V(); vertex++) {
					// Reverse so that adjacency list is in the same order as original
					Stack<Integer> stack = new Stack<>();
					for (int neighbor : graph.getAdjacencyList()[vertex]) {
						stack.push(neighbor);
					}
					for (int neighbor : stack) {
						adjacent[vertex].add(neighbor);
					}
				}
			}
		}


		public void addEdge(int vertex1, int vertex2) {
			adjacent[vertex1].add(vertex2);
			adjacent[vertex2].add(vertex1);
			edges++;
		}

		public Iterable<Integer> adjacent(int vertex) {
			return adjacent[vertex];
		}

		@Override
		public String toString() {
			StringBuilder stringBuilder = new StringBuilder();

			for (int vertex = 0; vertex < vertices(); vertex++) {
				stringBuilder.append(vertex).append(": ");

				for (int neighbor : adjacent(vertex)) {
					stringBuilder.append(neighbor).append(" ");
				}
				stringBuilder.append("\n");
			}

			return stringBuilder.toString();
		}
	}

	public static void main(String[] args) {
		StdOut.println("Exercise 4.1.3 by Victoria Golden");
		
		ConstructorCopy copy = new ConstructorCopy();

		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);

		CopyGraph copyGraph = copy.new CopyGraph(graph);
		StdOut.println("Copy:");
		StdOut.println(copyGraph);

		StdOut.println("Original:\n" + "0: 3 2 1\n" + "1: 4 2 0\n" + "2: 3 1 0\n" + "3: 2 0\n" + "4: 1\n");

		copyGraph.addEdge(0, 4);
		StdOut.println("Edges in original graph: " + graph.E() + " Expected: 6");
		StdOut.println("Edges in copy graph: " + copyGraph.edges() + " Expected: 7");
	}
}